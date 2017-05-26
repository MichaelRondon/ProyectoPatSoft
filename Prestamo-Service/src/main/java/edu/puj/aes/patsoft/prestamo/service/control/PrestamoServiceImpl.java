package edu.puj.aes.patsoft.prestamo.service.control;

import edu.puj.aes.patsoft.artifacts.cliente.ClienteBase;
import edu.puj.aes.patsoft.artifacts.prestamo.Entidad;
import edu.puj.aes.patsoft.artifacts.prestamo.Prestamo;
import edu.puj.aes.patsoft.artifacts.prestamo.Prestamos;
import edu.puj.aes.patsoft.prestamo.service.exception.PrestamoServiceException;
import edu.puj.aes.patsoft.prestamo.service.util.PrestamosUtil;
import java.math.BigDecimal;
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
 * @author Michael Felipe Rondón Acosta
 */
@Stateless
public class PrestamoServiceImpl implements PrestamoServiceLocal {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PrestamoServiceImpl.class);

    private static final Map<String, List<Prestamo>> PRESTAMOS = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {

        Prestamo prestamo;
        String[] cedulas = new String[]{"987654321", "987654322", "987654323", "987654324", "987654325"};
        Entidad entidad;
        LocalDate localDate = LocalDate.now();
        Random random = new Random();
        for (int i = 0; i < cedulas.length; i++) {
            List<Prestamo> prestamos = new LinkedList<>();
            for (int j = 0; i < i + 1; j++) {
                entidad = new Entidad();
                entidad.setId(2000 + i);
                entidad.setNombre(String.format("Empresa de servicios públicos %d", i));
                entidad.setNumeroCuenta(String.valueOf(random.nextInt(1000000)));

                prestamo = new Prestamo();
                prestamo.setId(1000 + i);
                prestamo.setEntidad(entidad);
                prestamo.setDiasMora(random.nextInt(i + 1));
                prestamo.setNumCuotas(12 + i);
                prestamo.setValorMora(new BigDecimal(random.nextInt(100000)));
                prestamo.setValorProximaCuota(new BigDecimal(random.nextInt(1000000)));
                prestamo.setValorSaldo(new BigDecimal(random.nextInt(10000000)));
                try {
                    XMLGregorianCalendar xcal = DatatypeFactory.newInstance().
                            newXMLGregorianCalendar(GregorianCalendar.from(
                                    localDate.plus(i + 1, ChronoUnit.DAYS)
                                    .atStartOfDay(ZoneId.systemDefault())));
                    prestamo.setFechaProximaCuota(xcal);
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(PrestamoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                prestamos.add(prestamo);
            }
            PRESTAMOS.put(cedulas[i], prestamos);
        }
    }

    @Override
    public Prestamos findAllByCliente(ClienteBase input) throws PrestamoServiceException {
        Prestamos prestamos = new Prestamos();
        if (Objects.isNull(input)) {
            PrestamosUtil.getInstance().throwException(getClass(),
                    "No hay un cliente para realizar la consulta");
        }
        if (Objects.isNull(input.getCedula()) || input.getCedula().isEmpty()) {
            PrestamosUtil.getInstance().throwException(getClass(),
                    "Se requiere el número de cédula del cliente");
        }
        String cedula = input.getCedula();
        LOGGER.info("Consulta de préstamos con la cédula: {}", cedula);
        if (!PRESTAMOS.containsKey(cedula)) {
            LOGGER.info("Se obtienen 0 prestamos");
            return prestamos;
        }
        prestamos.getPrestamos().addAll(PRESTAMOS.get(cedula));
        LOGGER.info("Se obtienen {} prestamos.", prestamos.getPrestamos().size());
        return prestamos;
    }
}
