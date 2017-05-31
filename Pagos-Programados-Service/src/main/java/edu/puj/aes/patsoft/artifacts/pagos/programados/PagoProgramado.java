//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.30 a las 10:36:20 PM COT 
//


package edu.puj.aes.patsoft.artifacts.pagos.programados;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PagoProgramado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PagoProgramado">
 *   &lt;complexContent>
 *     &lt;extension base="{}PagoProgramadoBase">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="entidad" type="{}Entidad"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{}Estado"/>
 *         &lt;element name="periodicidad" type="{}Periodicidad"/>
 *         &lt;element name="fechaProximaCuota" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tipoDePago" type="{}TipoDePago"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagoProgramado", propOrder = {
    "id",
    "entidad",
    "nombre",
    "estado",
    "periodicidad",
    "fechaProximaCuota",
    "valor",
    "tipoDePago"
})
public class PagoProgramado
    extends PagoProgramadoBase
{

    protected long id;
    @XmlElement(required = true)
    protected Entidad entidad;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Estado estado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Periodicidad periodicidad;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaProximaCuota;
    protected double valor;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoDePago tipoDePago;

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
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link Estado }
     *     
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link Estado }
     *     
     */
    public void setEstado(Estado value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad periodicidad.
     * 
     * @return
     *     possible object is
     *     {@link Periodicidad }
     *     
     */
    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    /**
     * Define el valor de la propiedad periodicidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Periodicidad }
     *     
     */
    public void setPeriodicidad(Periodicidad value) {
        this.periodicidad = value;
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
     * Obtiene el valor de la propiedad valor.
     * 
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     */
    public void setValor(double value) {
        this.valor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDePago.
     * 
     * @return
     *     possible object is
     *     {@link TipoDePago }
     *     
     */
    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }

    /**
     * Define el valor de la propiedad tipoDePago.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDePago }
     *     
     */
    public void setTipoDePago(TipoDePago value) {
        this.tipoDePago = value;
    }

}
