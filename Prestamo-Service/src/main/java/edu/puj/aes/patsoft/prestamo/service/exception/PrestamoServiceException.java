package edu.puj.aes.patsoft.prestamo.service.exception;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public class PrestamoServiceException extends Exception{

    public PrestamoServiceException() {
    }

    public PrestamoServiceException(String message) {
        super(message);
    }

    public PrestamoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrestamoServiceException(Throwable cause) {
        super(cause);
    }

    public PrestamoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
