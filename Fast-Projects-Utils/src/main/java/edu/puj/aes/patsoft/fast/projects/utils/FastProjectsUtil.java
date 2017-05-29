/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.fast.projects.utils;

import org.slf4j.LoggerFactory;

/**
 *
 * @author Michael Felipe Rond�n Acosta
 */
public class FastProjectsUtil {

    private FastProjectsUtil() {
    }

    public static FastProjectsUtil getInstance() {
        return PrestamosUtilHolder.INSTANCE;
    }

    private static class PrestamosUtilHolder {

        private static final FastProjectsUtil INSTANCE = new FastProjectsUtil();
    }

    public void throwException(Class class_, String errorMessage)
            throws Exception {
        LoggerFactory.getLogger(class_).error(errorMessage);
        throw new Exception(errorMessage);
    }
}
