//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.30 a las 10:36:20 PM COT 
//


package edu.puj.aes.patsoft.artifacts.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.patsoft.artifacts.cliente package. 
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

    private final static QName _ClienteBase_QNAME = new QName("", "ClienteBase");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.patsoft.artifacts.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClienteBase }
     * 
     */
    public ClienteBase createClienteBase() {
        return new ClienteBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteBase")
    public JAXBElement<ClienteBase> createClienteBase(ClienteBase value) {
        return new JAXBElement<ClienteBase>(_ClienteBase_QNAME, ClienteBase.class, null, value);
    }

}
