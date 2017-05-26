package edu.puj.aes.patsoft.prestamo.service.boundary;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.prestamo.Prestamos;
import edu.puj.aes.patsoft.prestamo.service.artifacts.PrestamoPort;
import edu.puj.aes.patsoft.prestamo.service.exception.PrestamoServiceException;
import javax.ejb.EJB;
import javax.jws.WebService;
import edu.puj.aes.patsoft.prestamo.service.control.PrestamoServiceLocal;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(endpointInterface = "edu.puj.aes.patsoft.prestamo.service.artifacts.PrestamoPort")
public class Prestamo implements PrestamoPort {
    
    @EJB
    PrestamoServiceLocal prestamoService;
    
    @Override
    public edu.puj.aes.patsoft.artifacts.prestamo.Prestamos findAllByCliente(ClienteBase input)
            throws PrestamoServiceException {
        return prestamoService.findAllByCliente(input);
    }

    @Override
    public Prestamos findAllByClienteSimple(String cedula) throws PrestamoServiceException {
        ClienteBase clienteBase = new ClienteBase();
        clienteBase.setCedula(cedula);
        return prestamoService.findAllByCliente(clienteBase);
    }
    
}
