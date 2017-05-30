/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.control;

import edu.puj.aes.patsoft.artifacts.pagos.programados.Transaccion;
import edu.puj.aes.patsoft.cics.service.exception.CICSException;
import edu.puj.aes.patsoft.cics.service.pagos.programados.wsdl.PagoProgramado;
import edu.puj.aes.patsoft.cics.service.pagos.programados.wsdl.PagoProgramadoBase;
import edu.puj.aes.patsoft.cics.service.pagos.programados.wsdl.PagoProgramadoPort;
import edu.puj.aes.patsoft.cics.service.pagos.programados.wsdl.PagoProgramadoService;
import edu.puj.aes.patsoft.cics.service.pagos.programados.wsdl.PagosProgramadosException_Exception;
import edu.puj.aes.patsoft.cics.service.util.CICSUtil;
import edu.puj.aes.patsoft.fast.projects.utils.JSONConverter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
public class PagoProgramadoProcessor implements MessageProcessor {

    private static final String PAGO_PROGRAMADO_WSDL_ENDPOINT = "http://localhost:8080/Pagos-Programados-Service/PagoProgramadoService?wsdl";

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PagoProgramadoProcessor.class);
    private final ConnectionManager connectionManager;

    public PagoProgramadoProcessor(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void process(Message message) {
        Transaccion buildTransaccion = null;
        try {
            buildTransaccion = buildTransaccion(message);
            PagoProgramadoBase pagoProgramadoBase = buildPagoProgramado(buildTransaccion);
            LOGGER.info("Pago programado base: {}. Referencia {}",
                    pagoProgramadoBase, pagoProgramadoBase.getReferencia());
            PagoProgramadoService pagoProgramadoService;

            pagoProgramadoService = new PagoProgramadoService(new URL(PAGO_PROGRAMADO_WSDL_ENDPOINT));
            PagoProgramadoPort pagoProgramadoPort = pagoProgramadoService.getPagoProgramadoPort();
            PagoProgramado notificarPagoProgramadoByRef = pagoProgramadoPort.notificarPagoProgramadoByRef(pagoProgramadoBase);

            buildTransaccion = this.buildTransaccion(notificarPagoProgramadoByRef);
        } catch (MalformedURLException | CICSException | PagosProgramadosException_Exception ex) {
            LOGGER.error("Error ejecutando transacción de Pago Programado", ex);
            sendMessage(buildMessage(buildTransaccion, ex));
        }
        sendMessage(buildMessage(buildTransaccion, null));
    }

    private String buildMessage(Transaccion transaccion, Exception exception) {
        if (transaccion != null) {
            if (exception != null) {
                transaccion.setMensajeError(exception.getMessage());
            }
            try {
                return JSONConverter.getInstance().convert(Transaccion.class, transaccion);
            } catch (JAXBException ex) {
                Logger.getLogger(PagoProgramadoProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><!DOCTYPE xml><transaccion><referencia></referencia><valor></valor><mensajeError>");
        stringBuilder.append(exception == null ? "Imposible de convertir el mensaje" : exception.getMessage());
        stringBuilder.append("</mensajeError><exito>0</exito></transaccion>");
        return stringBuilder.toString();
    }

    private void sendMessage(String message) {
        try {
            connectionManager.publishMessage("procesadas", message);
        } catch (JMSException | InterruptedException ex) {
            LOGGER.error("Error publicando la respuesta de la transacción", ex);
        }
    }

    private Transaccion buildTransaccion(PagoProgramado pagoProgramado) {
        Transaccion transaccion = new Transaccion();
        transaccion.setExito(1);
        transaccion.setReferencia(pagoProgramado.getReferencia());
        transaccion.setValor(pagoProgramado.getValor());
        return transaccion;
    }

    private Transaccion buildTransaccion(Message message) throws CICSException {
        if (message instanceof TextMessage) {
            try {
                TextMessage textMessage = (TextMessage) message;
                return JSONConverter.getInstance().convert(Transaccion.class, textMessage.getText());
            } catch (JMSException | JAXBException ex) {
                String errorMessage = String.format("Error realizando la conversión del mensaje de la cola.Mensaje: %s", message);
                CICSUtil.getInstance().throwException(getClass(), errorMessage);
            }
        } else {
            String errorMessage = String.format("Error ejecutando transacción de Pago Programado. El mensaje debería ser del tipo TextMessage. Mensaje: %s", message);
            CICSUtil.getInstance().throwException(getClass(), errorMessage);
        }
        return null;
    }

    private PagoProgramadoBase buildPagoProgramado(Transaccion transaccion) throws CICSException {
        PagoProgramadoBase pagoProgramadoBase = new PagoProgramadoBase();
        pagoProgramadoBase.setReferencia(transaccion.getReferencia());
        return pagoProgramadoBase;
    }
}
