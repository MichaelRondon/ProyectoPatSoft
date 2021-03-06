/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.control;

import java.util.concurrent.CountDownLatch;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
public class ConnectionManager implements Latcher {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManager.class);
    
    private final String connectionUri;
    private final String login;
    private final String password;
    private final CountDownLatch latch = new CountDownLatch(1);
    
    public ConnectionManager(String connectionUri, String login,
            String password) {
        this.connectionUri = connectionUri;
        this.login = login;
        this.password = password;
    }
    
    public void receiveAsyncMessages(String queueName, MessageListener messageListener) throws
            JMSException, InterruptedException {
        Connection connection = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                connectionUri);
        connection = connectionFactory.createConnection(login, password);
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        try {
            Queue queue = session.createQueue(queueName);
            // Consumer
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(messageListener);
            
            connection.start();
            latch.await();
        } finally {
            if (session != null) {
                session.close();
            }
            connection.close();
        }
    }
    
    public void publishMessage(String queueName, String message) throws
            JMSException, InterruptedException {
        LOGGER.info("Mensaje a enviar {}", message);
        Connection connection = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                connectionUri);
        connection = connectionFactory.createConnection(login, password);
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        try {
            Queue queue = session.createQueue(queueName);
            
            MessageProducer producer = session.createProducer(queue);
            Message msg = session.createTextMessage(message);
            producer.send(msg);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public void latchCountDown() {
        latch.countDown();
    }
    
}
