/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.control;

import javax.jms.Message;

/**
 *
 * @author acost
 */
public interface MessageProcessor {
    
    void process(Message message);
    
}
