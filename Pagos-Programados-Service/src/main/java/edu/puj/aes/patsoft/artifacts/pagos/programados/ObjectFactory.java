//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.27 a las 01:50:43 AM COT 
//


package edu.puj.aes.patsoft.artifacts.pagos.programados;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.patsoft.artifacts.pagos.programados package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PagoProgramadoBase_QNAME = new QName("", "PagoProgramadoBase");
    private final static QName _PagoProgramado_QNAME = new QName("", "PagoProgramado");
    private final static QName _PagosProgramados_QNAME = new QName("", "PagosProgramados");
    private final static QName _Entidad_QNAME = new QName("", "Entidad");
    private final static QName _Estado_QNAME = new QName("", "Estado");
    private final static QName _Periodicidad_QNAME = new QName("", "Periodicidad");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.patsoft.artifacts.pagos.programados
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PagoProgramadoBase }
     * 
     */
    public PagoProgramadoBase createPagoProgramadoBase() {
        return new PagoProgramadoBase();
    }

    /**
     * Create an instance of {@link PagoProgramado }
     * 
     */
    public PagoProgramado createPagoProgramado() {
        return new PagoProgramado();
    }

    /**
     * Create an instance of {@link PagosProgramados }
     * 
     */
    public PagosProgramados createPagosProgramados() {
        return new PagosProgramados();
    }

    /**
     * Create an instance of {@link Entidad }
     * 
     */
    public Entidad createEntidad() {
        return new Entidad();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagoProgramadoBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PagoProgramadoBase")
    public JAXBElement<PagoProgramadoBase> createPagoProgramadoBase(PagoProgramadoBase value) {
        return new JAXBElement<PagoProgramadoBase>(_PagoProgramadoBase_QNAME, PagoProgramadoBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagoProgramado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PagoProgramado")
    public JAXBElement<PagoProgramado> createPagoProgramado(PagoProgramado value) {
        return new JAXBElement<PagoProgramado>(_PagoProgramado_QNAME, PagoProgramado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagosProgramados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PagosProgramados")
    public JAXBElement<PagosProgramados> createPagosProgramados(PagosProgramados value) {
        return new JAXBElement<PagosProgramados>(_PagosProgramados_QNAME, PagosProgramados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Entidad")
    public JAXBElement<Entidad> createEntidad(Entidad value) {
        return new JAXBElement<Entidad>(_Entidad_QNAME, Entidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Estado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Estado")
    public JAXBElement<Estado> createEstado(Estado value) {
        return new JAXBElement<Estado>(_Estado_QNAME, Estado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Periodicidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Periodicidad")
    public JAXBElement<Periodicidad> createPeriodicidad(Periodicidad value) {
        return new JAXBElement<Periodicidad>(_Periodicidad_QNAME, Periodicidad.class, null, value);
    }

}
