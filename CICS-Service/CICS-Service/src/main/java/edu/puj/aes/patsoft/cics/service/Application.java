/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service;

import edu.puj.aes.patsoft.cics.service.control.ConnectionManager;
import edu.puj.aes.patsoft.cics.service.control.ConsumerMessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;

/**
 *
 * @author acost
 */
public class Application {

    public static void main(String[] args) {
        try {
            ConnectionManager connectionManager = new ConnectionManager("tcp://25.12.96.121:61616", "admin", "admin");
            connectionManager.receiveAsyncMessages("pendientes", new ConsumerMessageListener("Customer", connectionManager));
        } catch (JMSException | InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
