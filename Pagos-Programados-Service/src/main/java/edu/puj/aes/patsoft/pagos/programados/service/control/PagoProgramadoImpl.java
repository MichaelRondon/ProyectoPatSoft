/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.control;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.Entidad;
import edu.puj.aes.patsoft.artifacts.pagos.programados.Estado;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramado;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagoProgramadoBase;
import edu.puj.aes.patsoft.artifacts.pagos.programados.PagosProgramados;
import edu.puj.aes.patsoft.artifacts.pagos.programados.Periodicidad;
import edu.puj.aes.patsoft.pagos.programados.service.exception.PagosProgramadosException;
import edu.puj.aes.patsoft.pagos.programados.service.util.PagosProgramadosUtil;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@Stateless
public class PagoProgramadoImpl implements PagoProgramadoLocal {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PagoProgramadoImpl.class);

    private static final Map<String, List<PagoProgramado>> PAGO_PROGRAMADO = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {

        if (PAGO_PROGRAMADO.isEmpty()) {
            generarPagosProgramados();
        }

    }

    @Override
    public PagosProgramados findAllByCliente(ClienteBase input) throws PagosProgramadosException {
        validarCliente(input);
        return consultarPagosProgramados(input);
    }

    @Override
    public PagoProgramado notificarPagoProgramado(PagoProgramadoBase input,
            ClienteBase input2) throws PagosProgramadosException {
        validarCliente(input2);
        PagosProgramados consultarPagosProgramados = consultarPagosProgramados(input2);
        if (consultarPagosProgramados.getPagosProgramados().isEmpty()) {
            PagosProgramadosUtil.getInstance().throwException(getClass(),
                    String.format("No se encuentra el pago programado. El cliente con cédula %s no tiene pagos programados",
                            input2.getCedula()));
        }
        PagoProgramado pagoProgramado = consultarPagosProgramados.getPagosProgramados().parallelStream()
                .filter(pago -> pago.getReferencia().equals(input.getReferencia()))
                .findAny().orElseThrow(
                        () -> new PagosProgramadosException(String.format("No se encuentra el pago programado con referencia %s", input.getReferencia())));
        setSiguienteFechaPago(pagoProgramado);
        return pagoProgramado;
    }

    private void setSiguienteFechaPago(PagoProgramado pagoProgramado) {

        LocalDate localDate = LocalDate.now();
        switch (pagoProgramado.getPeriodicidad()) {
            case BIMENSUAL:
                localDate = localDate.plus(2, ChronoUnit.MONTHS);
                break;
            case MENSUAL:
                localDate = localDate.plus(1, ChronoUnit.MONTHS);
                break;
            case QUINCENAL:
                localDate = localDate.plus(2, ChronoUnit.WEEKS);
                break;
            case SEMANAL:
                localDate = localDate.plus(1, ChronoUnit.WEEKS);
                break;
        }

        try {
            XMLGregorianCalendar xcal = DatatypeFactory.newInstance().
                    newXMLGregorianCalendar(GregorianCalendar.from(
                            localDate.atStartOfDay(ZoneId.systemDefault())));
            pagoProgramado.setFechaProximaCuota(xcal);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void generarPagosProgramados() {
        PagoProgramado pagoProgramado;
        String[] cedulas = new String[]{"987654321", "987654322", "987654323", "987654324", "987654325"};
        Entidad entidad;
        LocalDate localDate = LocalDate.now();
        Random random = new Random();
        for (int i = 0; i < cedulas.length; i++) {
            List<PagoProgramado> pagosProgramados = new LinkedList<>();
            for (int j = 0; j < i + 1; j++) {
                entidad = new Entidad();
                entidad.setId(2000 + j);
                entidad.setNombre(String.format("Empresa de servicios públicos %d", j + 1));
                entidad.setNumeroCuenta(String.valueOf(random.nextInt(1000000)));

                pagoProgramado = new PagoProgramado();
                pagoProgramado.setId(1000 + j);
                pagoProgramado.setEntidad(entidad);
                pagoProgramado.setEstado(Estado.ACTIVO);
                pagoProgramado.setNombre(String.format("Pago programado n%d", j + 1));
                pagoProgramado.setPeriodicidad(Periodicidad.SEMANAL);
                pagoProgramado.setReferencia(String.valueOf(random.nextInt(100000)));
                try {
                    XMLGregorianCalendar xcal = DatatypeFactory.newInstance().
                            newXMLGregorianCalendar(GregorianCalendar.from(
                                    //                                    localDate.plus(i + 1, ChronoUnit.DAYS)
                                    localDate
                                            .atStartOfDay(ZoneId.systemDefault())));
                    pagoProgramado.setFechaProximaCuota(xcal);
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
                pagosProgramados.add(pagoProgramado);
            }
            PAGO_PROGRAMADO.put(cedulas[i], pagosProgramados);
        }
    }

    private PagosProgramados consultarPagosProgramados(ClienteBase input) {
        PagosProgramados pagosProgramados = new PagosProgramados();
        String cedula = input.getCedula();
        LOGGER.info("Consulta de pagos programados con la cédula: {}", cedula);
        if (!PAGO_PROGRAMADO.containsKey(cedula)) {
            LOGGER.info("Se obtienen 0 pagos programados");
            return pagosProgramados;
        }
        pagosProgramados.getPagosProgramados().addAll(PAGO_PROGRAMADO.get(cedula));
        LOGGER.info("Se obtienen {} pagos programados.", pagosProgramados.getPagosProgramados().size());
        return pagosProgramados;

    }

    private void validarCliente(ClienteBase input) throws PagosProgramadosException {
        if (Objects.isNull(input)) {
            PagosProgramadosUtil.getInstance().throwException(getClass(),
                    "No hay un cliente para realizar la consulta");
        }
        if (Objects.isNull(input.getCedula()) || input.getCedula().isEmpty()) {
            PagosProgramadosUtil.getInstance().throwException(getClass(),
                    "Se requiere el número de cédula del cliente");
        }
    }

}
