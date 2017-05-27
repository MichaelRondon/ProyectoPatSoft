/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.control;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramado;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramadoBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagosProgramados;
import edu.puj.aes.patsoft.pagos.programados.service.exception.PagosProgramadosException;
import javax.ejb.Local;

/**
 *
 * @author acost
 */
@Local
public interface PagoProgramadoLocal {

    PagosProgramados findAllByCliente(ClienteBase input) throws PagosProgramadosException;

    PagoProgramado notificarPagoProgramado(PagoProgramadoBase input,
            ClienteBase input2) throws PagosProgramadosException;
}
