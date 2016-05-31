
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu30Chitietketquavpv complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu30Chitietketquavpv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diemcandat" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="diemdatduoc" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="machitietdmkqpv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="madkpv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tendkpv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu30Chitietketquavpv", propOrder = {
    "diemcandat",
    "diemdatduoc",
    "id",
    "machitietdmkqpv",
    "madkpv",
    "tendkpv"
})
public class Tlu30Chitietketquavpv {

    protected float diemcandat;
    protected float diemdatduoc;
    protected Integer id;
    protected String machitietdmkqpv;
    protected String madkpv;
    protected String tendkpv;

    /**
     * Gets the value of the diemcandat property.
     * 
     */
    public float getDiemcandat() {
        return diemcandat;
    }

    /**
     * Sets the value of the diemcandat property.
     * 
     */
    public void setDiemcandat(float value) {
        this.diemcandat = value;
    }

    /**
     * Gets the value of the diemdatduoc property.
     * 
     */
    public float getDiemdatduoc() {
        return diemdatduoc;
    }

    /**
     * Sets the value of the diemdatduoc property.
     * 
     */
    public void setDiemdatduoc(float value) {
        this.diemdatduoc = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the machitietdmkqpv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachitietdmkqpv() {
        return machitietdmkqpv;
    }

    /**
     * Sets the value of the machitietdmkqpv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachitietdmkqpv(String value) {
        this.machitietdmkqpv = value;
    }

    /**
     * Gets the value of the madkpv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMadkpv() {
        return madkpv;
    }

    /**
     * Sets the value of the madkpv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMadkpv(String value) {
        this.madkpv = value;
    }

    /**
     * Gets the value of the tendkpv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTendkpv() {
        return tendkpv;
    }

    /**
     * Sets the value of the tendkpv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTendkpv(String value) {
        this.tendkpv = value;
    }

}
