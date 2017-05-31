/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.control;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
public class ConsumerMessageListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMessageListener.class);
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private final MessageProcessor messageProcessor;
    private final Latcher latcher;

    public ConsumerMessageListener(MessageProcessor messageProcessor, Latcher latcher) {
        this.messageProcessor = messageProcessor;
        this.latcher = latcher;
    }

    @Override
    public void onMessage(Message message) {
        LOGGER.info("Mensaje obtenido de la cola: {}" + message);

        try {
            if (message instanceof MapMessage) {
                System.out.println("messageType: MapMessage");
            } else if (message instanceof BytesMessage) {
                System.out.println("messageType: BytesMessage");
                BytesMessage bytesMessage = (BytesMessage) message;
                byte[] data;
                data = new byte[(int) bytesMessage.getBodyLength()];
                bytesMessage.readBytes(data);
                System.out.println("String(): " + new String(data));
            } else if (message instanceof StreamMessage) {
                System.out.println("messageType: StreamMessage");
            } else if (message instanceof TextMessage) {
                System.out.println("messageType: TextMessage");
                TextMessage textMessage = (TextMessage) message;
                System.out.println("textMessage: " + textMessage.getText());
            } else {
                System.out.println("NINGUNO");
            }

            if (COUNTER.get() == 2) {
                System.out.println("*****ERROR DE PRUEBA*****");
                try {
                    ((ConnectionManager) latcher).publishMessage("procesadas", "<?xml version=\"1.0\" encoding=\"utf-8\"?><!DOCTYPE xml><transaccion><referencia></referencia><valor></valor><mensajeError>Error Dummy de prueba</mensajeError><exito>0</exito></transaccion>");
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(ConsumerMessageListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                messageProcessor.process(message);
            }
            if (COUNTER.getAndIncrement() == 3) {
                latcher.latchCountDown();
            }
        } catch (JMSException /*| IOException*/ ex) {
            String errorMessage
                    = String.format("Error procesando el mensaje: %s. error:%s",
                            message, ex.getMessage());
            java.util.logging.Logger.getLogger(ConsumerMessageListener.class.getName()).log(Level.SEVERE, errorMessage, ex);
            latcher.latchCountDown();
        }
    }
}
