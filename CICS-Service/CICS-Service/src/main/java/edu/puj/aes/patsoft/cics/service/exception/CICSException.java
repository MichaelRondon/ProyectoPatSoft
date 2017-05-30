/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.exception;

/**
 *
 * @author acost
 */
public class CICSException extends Exception{

    public CICSException() {
    }

    public CICSException(String message) {
        super(message);
    }

    public CICSException(String message, Throwable cause) {
        super(message, cause);
    }

    public CICSException(Throwable cause) {
        super(cause);
    }

    public CICSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
