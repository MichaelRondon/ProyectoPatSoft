/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.prestamo.service.artifacts;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.prestamo.Prestamos;
import edu.puj.aes.patsoft.prestamo.service.exception.PrestamoServiceException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(name = "PrestamoPort", targetNamespace = "http://www.patsoft.aes.puj.edu.co")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PrestamoPort {
    
    @WebMethod(operationName = "FindAllByCliente", action = "findAllByCliente")
    @WebResult(name = "Prestamos", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Output")
    public Prestamos findAllByCliente (
        @WebParam(name = "Cliente", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Input")
        ClienteBase input) throws PrestamoServiceException;
    
    @WebMethod(operationName = "FindAllByClienteSimple", action = "findAllByCliente")
    @WebResult(name = "Prestamos", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Output")
    public Prestamos findAllByClienteSimple (
        @WebParam(name = "cedula", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Input")
        String cedula) throws PrestamoServiceException;
    
}
