//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.26 a las 02:33:33 PM COT 
//


package edu.puj.aes.patsoft.artifacts.prestamo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Prestamo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Prestamo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="entidad" type="{}Entidad"/>
 *         &lt;element name="valorSaldo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="fechaProximaCuota" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="valorProximaCuota" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="numCuotas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="diasMora" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valorMora" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prestamo", propOrder = {
    "id",
    "entidad",
    "valorSaldo",
    "fechaProximaCuota",
    "valorProximaCuota",
    "numCuotas",
    "diasMora",
    "valorMora"
})
public class Prestamo {

    protected long id;
    @XmlElement(required = true)
    protected Entidad entidad;
    @XmlElement(required = true)
    protected BigDecimal valorSaldo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaProximaCuota;
    @XmlElement(required = true)
    protected BigDecimal valorProximaCuota;
    protected int numCuotas;
    protected int diasMora;
    @XmlElement(required = true)
    protected BigDecimal valorMora;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad entidad.
     * 
     * @return
     *     possible object is
     *     {@link Entidad }
     *     
     */
    public Entidad getEntidad() {
        return entidad;
    }

    /**
     * Define el valor de la propiedad entidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Entidad }
     *     
     */
    public void setEntidad(Entidad value) {
        this.entidad = value;
    }

    /**
     * Obtiene el valor de la propiedad valorSaldo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorSaldo() {
        return valorSaldo;
    }

    /**
     * Define el valor de la propiedad valorSaldo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorSaldo(BigDecimal value) {
        this.valorSaldo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaProximaCuota.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaProximaCuota() {
        return fechaProximaCuota;
    }

    /**
     * Define el valor de la propiedad fechaProximaCuota.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaProximaCuota(XMLGregorianCalendar value) {
        this.fechaProximaCuota = value;
    }

    /**
     * Obtiene el valor de la propiedad valorProximaCuota.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorProximaCuota() {
        return valorProximaCuota;
    }

    /**
     * Define el valor de la propiedad valorProximaCuota.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorProximaCuota(BigDecimal value) {
        this.valorProximaCuota = value;
    }

    /**
     * Obtiene el valor de la propiedad numCuotas.
     * 
     */
    public int getNumCuotas() {
        return numCuotas;
    }

    /**
     * Define el valor de la propiedad numCuotas.
     * 
     */
    public void setNumCuotas(int value) {
        this.numCuotas = value;
    }

    /**
     * Obtiene el valor de la propiedad diasMora.
     * 
     */
    public int getDiasMora() {
        return diasMora;
    }

    /**
     * Define el valor de la propiedad diasMora.
     * 
     */
    public void setDiasMora(int value) {
        this.diasMora = value;
    }

    /**
     * Obtiene el valor de la propiedad valorMora.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorMora() {
        return valorMora;
    }

    /**
     * Define el valor de la propiedad valorMora.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorMora(BigDecimal value) {
        this.valorMora = value;
    }

}
