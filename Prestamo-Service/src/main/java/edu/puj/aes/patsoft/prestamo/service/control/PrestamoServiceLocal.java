/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.prestamo.service.control;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.prestamo.Prestamos;
import edu.puj.aes.patsoft.prestamo.service.exception.PrestamoServiceException;
import javax.ejb.Local;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@Local
public interface PrestamoServiceLocal {

    public Prestamos findAllByCliente(ClienteBase input) throws PrestamoServiceException;

}
