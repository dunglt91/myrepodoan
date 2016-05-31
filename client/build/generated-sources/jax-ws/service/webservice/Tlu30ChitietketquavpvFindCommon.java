
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30chitietketquavpvFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30chitietketquavpvFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Machitietdmkqpv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Madkpv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tendkpv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Diemcandat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Diemdatduoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30chitietketquavpvFindCommon", propOrder = {
    "machitietdmkqpv",
    "madkpv",
    "tendkpv",
    "diemcandat",
    "diemdatduoc"
})
public class Tlu30ChitietketquavpvFindCommon {

    @XmlElement(name = "Machitietdmkqpv")
    protected String machitietdmkqpv;
    @XmlElement(name = "Madkpv")
    protected String madkpv;
    @XmlElement(name = "Tendkpv")
    protected String tendkpv;
    @XmlElement(name = "Diemcandat")
    protected String diemcandat;
    @XmlElement(name = "Diemdatduoc")
    protected String diemdatduoc;

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

    /**
     * Gets the value of the diemcandat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiemcandat() {
        return diemcandat;
    }

    /**
     * Sets the value of the diemcandat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiemcandat(String value) {
        this.diemcandat = value;
    }

    /**
     * Gets the value of the diemdatduoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiemdatduoc() {
        return diemdatduoc;
    }

    /**
     * Sets the value of the diemdatduoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiemdatduoc(String value) {
        this.diemdatduoc = value;
    }

}
