//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.29 a las 10:46:45 PM COT 
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

    private final static QName _Transaccion_QNAME = new QName("", "transaccion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.patsoft.artifacts.pagos.programados
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Transaccion }
     * 
     */
    public Transaccion createTransaccion() {
        return new Transaccion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transaccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "transaccion")
    public JAXBElement<Transaccion> createTransaccion(Transaccion value) {
        return new JAXBElement<Transaccion>(_Transaccion_QNAME, Transaccion.class, null, value);
    }

}
