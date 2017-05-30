/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.cics.service.util;

import edu.puj.aes.patsoft.cics.service.exception.CICSException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
public class CICSUtil {
    
    private CICSUtil() {
    }
    
    public static CICSUtil getInstance() {
        return CICSUtilHolder.INSTANCE;
    }
    
    private static class CICSUtilHolder {

        private static final CICSUtil INSTANCE = new CICSUtil();
    }

    public void throwException(Class class_, String errorMessage)
            throws CICSException {
        LoggerFactory.getLogger(class_).error(errorMessage);
        throw new CICSException(errorMessage);
    }
}
