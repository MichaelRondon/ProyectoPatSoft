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
import edu.puj.aes.patsoft.fast.projects.utils.FilePersister;
import edu.puj.aes.patsoft.pagos.programados.service.exception.PagosProgramadosException;
import edu.puj.aes.patsoft.pagos.programados.service.util.PagosProgramadosUtil;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
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

    private static final FilePersister FILE_PERSISTER
            = new FilePersister("persistence/pagos/programados");

    private static final String FILE_NAME = "PAGOS_PROGRAMADOS";

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PagoProgramadoImpl.class);

    private static final Map<String, List<PagoProgramado>> PAGOS_PROGRAMADOS = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        cargar();
        if (PAGOS_PROGRAMADOS.isEmpty()) {
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
        guardar();
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
            PAGOS_PROGRAMADOS.put(cedulas[i], pagosProgramados);
        }
    }

    private PagosProgramados consultarPagosProgramados(ClienteBase input) {
        PagosProgramados pagosProgramados = new PagosProgramados();
        String cedula = input.getCedula();
        LOGGER.info("Consulta de pagos programados con la cédula: {}", cedula);
        if (!PAGOS_PROGRAMADOS.containsKey(cedula)) {
            LOGGER.info("Se obtienen 0 pagos programados");
            return pagosProgramados;
        }
        pagosProgramados.getPagosProgramados().addAll(PAGOS_PROGRAMADOS.get(cedula));
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

    private synchronized void guardar() {
        if (PAGOS_PROGRAMADOS != null && !PAGOS_PROGRAMADOS.isEmpty()) {
            HashMap<String, List<PagoProgramado>> map = new HashMap<>();
            PAGOS_PROGRAMADOS.forEach((key, value) -> map.put(key, value));
            FILE_PERSISTER.guardar(FILE_NAME, map);
        }
    }

    private synchronized void cargar() {
        HashMap cargar = FILE_PERSISTER.cargar(FILE_NAME, HashMap.class);
        if (cargar != null && !cargar.isEmpty()) {
            PAGOS_PROGRAMADOS.clear();
            Set entrySet = cargar.entrySet();
            entrySet.forEach(entry
                    -> PAGOS_PROGRAMADOS.put((String) ((Entry) entry).getKey(),
                            getPagosProgramados((List<LinkedHashMap>) ((Entry) entry).getValue())));
        }
    }

    private List<PagoProgramado> getPagosProgramados(List<LinkedHashMap> linkedHashMaps) {
        List<PagoProgramado> pagoProgramados = new LinkedList<>();
        linkedHashMaps.forEach(linkedHashMap -> 
                pagoProgramados.add(getPagoProgramado(linkedHashMap)));
        return pagoProgramados;
    }

    private PagoProgramado getPagoProgramado(LinkedHashMap linkedHashMap) {
        return FILE_PERSISTER.convert(PagoProgramado.class, linkedHashMap);
    }
}
