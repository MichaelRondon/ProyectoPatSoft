/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.artifacts;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramado;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramadoBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagosProgramados;
import edu.puj.aes.patsoft.pagos.programados.service.exception.PagosProgramadosException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author acost
 */
@WebService(name = "PagoProgramadoPort", targetNamespace = "http://www.patsoft.aes.puj.edu.co")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface PagoProgramadoPort {

    @WebMethod(operationName = "FindAllByCliente", action = "findAllByCliente")
    @WebResult(name = "PagosProgramados", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Output")
    public PagosProgramados findAllByCliente(
            @WebParam(name = "Cliente", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Input") ClienteBase input) throws PagosProgramadosException;

    @WebMethod(operationName = "NotificarPagoProgramado", action = "notificarPagoProgramado")
    @WebResult(name = "PagoProgramado", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Output2")
    public PagoProgramado notificarPagoProgramado(
            @WebParam(name = "PagoProgramado", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Input1") PagoProgramadoBase input,
            @WebParam(name = "Cliente", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Input2") ClienteBase input2) throws PagosProgramadosException;
    
    @WebMethod(operationName = "NotificarPagoProgramadoByRef", action = "notificarPagoProgramadoByRef")
    @WebResult(name = "PagoProgramado", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Output4")
    public PagoProgramado notificarPagoProgramadoByRef(
            @WebParam(name = "PagoProgramado", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Input1") PagoProgramadoBase input) 
            throws PagosProgramadosException;

    @WebMethod(operationName = "FindAllByFechaProximoPagoNow", action = "findAllByFechaProximoPagoNow")
    @WebResult(name = "PagoProgramado", targetNamespace = "http://www.patsoft.aes.puj.edu.co", partName = "Output3")
    public PagosProgramados findAllByFechaProximoPagoNow() throws PagosProgramadosException;
}
