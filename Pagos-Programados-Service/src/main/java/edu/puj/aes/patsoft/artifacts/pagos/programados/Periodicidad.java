//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.30 a las 10:36:20 PM COT 
//


package edu.puj.aes.patsoft.artifacts.pagos.programados;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Periodicidad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Periodicidad">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SEMANAL"/>
 *     &lt;enumeration value="QUINCENAL"/>
 *     &lt;enumeration value="MENSUAL"/>
 *     &lt;enumeration value="BIMENSUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Periodicidad")
@XmlEnum
public enum Periodicidad {

    SEMANAL,
    QUINCENAL,
    MENSUAL,
    BIMENSUAL;

    public String value() {
        return name();
    }

    public static Periodicidad fromValue(String v) {
        return valueOf(v);
    }

}
