/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.control;

import edu.puj.aes.patsoft.cics.service.Application;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author acost
 */
public class ControlServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        try {
            ConnectionManager connectionManager = new ConnectionManager("tcp://25.12.96.121:61616", "admin", "admin");
            connectionManager.publishMessage("pendientes", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                    + "<!DOCTYPE xml>\n"
                    + "<transaccion>\n"
                    + "  <referencia>92158</referencia>\n"
                    + "</transaccion>");
            connectionManager.receiveAsyncMessages("pendientes", new ConsumerMessageListener(new PagoProgramadoProcessor(connectionManager), connectionManager));
        } catch (JMSException | InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
