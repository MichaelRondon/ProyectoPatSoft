/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.boundary;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagosProgramados;
import edu.puj.aes.patsoft.pagos.programados.service.artifacts.PagoProgramadoPort;
import edu.puj.aes.patsoft.pagos.programados.service.control.PagoProgramadoLocal;
import edu.puj.aes.patsoft.pagos.programados.service.exception.PagosProgramadosException;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.patsoft.pagos.programados.service.artifacts.PagoProgramadoPort")
public class PagoProgramado implements PagoProgramadoPort {

    @EJB
    PagoProgramadoLocal pagoProgramado;

    @Override
    public PagosProgramados findAllByCliente(ClienteBase input) throws PagosProgramadosException {
        return pagoProgramado.findAllByCliente(input);
    }

    @Override
    public edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramado notificarPagoProgramado(edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramadoBase input, ClienteBase input2) throws PagosProgramadosException {
        return pagoProgramado.notificarPagoProgramado(input, input2);
    }

    @Override
    public PagosProgramados findAllByFechaProximoPagoNow() throws PagosProgramadosException {
        return pagoProgramado.findAllByFechaProximoPagoNow();
    }
}
