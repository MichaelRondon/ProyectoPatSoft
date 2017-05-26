/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.prestamo.service.util;

import edu.puj.aes.patsoft.prestamo.service.exception.PrestamoServiceException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public class PrestamosUtil {

    private PrestamosUtil() {
    }

    public static PrestamosUtil getInstance() {
        return PrestamosUtilHolder.INSTANCE;
    }

    private static class PrestamosUtilHolder {

        private static final PrestamosUtil INSTANCE = new PrestamosUtil();
    }

    public void throwException(Class class_, String errorMessage)
            throws PrestamoServiceException {
        LoggerFactory.getLogger(class_).error(errorMessage);
        throw new PrestamoServiceException(errorMessage);
    }
}
