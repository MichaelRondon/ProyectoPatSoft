/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.exception;

/**
 *
 * @author acost
 */
public class PagosProgramadosException extends Exception{

    public PagosProgramadosException() {
    }

    public PagosProgramadosException(String message) {
        super(message);
    }

    public PagosProgramadosException(String message, Throwable cause) {
        super(message, cause);
    }

    public PagosProgramadosException(Throwable cause) {
        super(cause);
    }

    public PagosProgramadosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
