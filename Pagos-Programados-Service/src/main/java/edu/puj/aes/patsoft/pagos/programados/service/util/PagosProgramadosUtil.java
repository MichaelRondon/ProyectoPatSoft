/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.util;

import edu.puj.aes.patsoft.pagos.programados.service.exception.PagosProgramadosException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public class PagosProgramadosUtil {

    private PagosProgramadosUtil() {
    }

    public static PagosProgramadosUtil getInstance() {
        return PrestamosUtilHolder.INSTANCE;
    }

    private static class PrestamosUtilHolder {

        private static final PagosProgramadosUtil INSTANCE = new PagosProgramadosUtil();
    }

    public void throwException(Class class_, String errorMessage)
            throws PagosProgramadosException {
        LoggerFactory.getLogger(class_).error(errorMessage);
        throw new PagosProgramadosException(errorMessage);
    }
}
