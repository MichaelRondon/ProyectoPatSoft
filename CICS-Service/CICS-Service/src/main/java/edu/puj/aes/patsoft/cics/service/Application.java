/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service;

import edu.puj.aes.patsoft.cics.service.control.ConnectionManager;
import edu.puj.aes.patsoft.cics.service.control.ConsumerMessageListener;
import edu.puj.aes.patsoft.cics.service.control.PagoProgramadoProcessor;
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
//            connectionManager.publishMessage("pendientes", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
//                    + "<!DOCTYPE xml>\n"
//                    + "<transaccion>\n"
//                    + "  <referencia>92150</referencia>\n"
//                    + "</transaccion>");
//            connectionManager.publishMessage("pendientes", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
//                    + "<!DOCTYPE xml>\n"
//                    + "<transaccion>\n"
//                    + "  <referencia>92151</referencia>\n"
//                    + "</transaccion>");
//            connectionManager.publishMessage("pendientes", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
//                    + "<!DOCTYPE xml>\n"
//                    + "<transaccion>\n"
//                    + "  <referencia>92152</referencia>\n"
//                    + "</transaccion>");
//            connectionManager.publishMessage("pendientes", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
//                    + "<!DOCTYPE xml>\n"
//                    + "<transaccion>\n"
//                    + "  <referencia>92153</referencia>\n"
//                    + "</transaccion>");
//            connectionManager.publishMessage("pendientes", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
//                    + "<!DOCTYPE xml>\n"
//                    + "<transaccion>\n"
//                    + "  <referencia>92154</referencia>\n"
//                    + "</transaccion>");
            connectionManager.receiveAsyncMessages("pendientes", new ConsumerMessageListener(new PagoProgramadoProcessor(connectionManager), connectionManager));
            System.exit(0);
        } catch (JMSException | InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
