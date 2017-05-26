//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.26 a las 02:33:33 PM COT 
//


package edu.puj.aes.patsoft.artifacts.prestamo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.patsoft.artifacts.prestamo package. 
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

    private final static QName _Prestamo_QNAME = new QName("", "Prestamo");
    private final static QName _Entidad_QNAME = new QName("", "Entidad");
    private final static QName _Prestamos_QNAME = new QName("", "Prestamos");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.patsoft.artifacts.prestamo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Prestamo }
     * 
     */
    public Prestamo createPrestamo() {
        return new Prestamo();
    }

    /**
     * Create an instance of {@link Entidad }
     * 
     */
    public Entidad createEntidad() {
        return new Entidad();
    }

    /**
     * Create an instance of {@link Prestamos }
     * 
     */
    public Prestamos createPrestamos() {
        return new Prestamos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prestamo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Prestamo")
    public JAXBElement<Prestamo> createPrestamo(Prestamo value) {
        return new JAXBElement<Prestamo>(_Prestamo_QNAME, Prestamo.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Prestamos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Prestamos")
    public JAXBElement<Prestamos> createPrestamos(Prestamos value) {
        return new JAXBElement<Prestamos>(_Prestamos_QNAME, Prestamos.class, null, value);
    }

}
