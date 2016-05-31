
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tlu20DieuKienTuyenDung complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu20DieuKienTuyenDung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDktd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="madmdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tendmdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu20DieuKienTuyenDung", propOrder = {
    "createdAt",
    "createdBy",
    "idDktd",
    "isActive",
    "madmdktd",
    "tendmdktd"
})
public class Tlu20DieuKienTuyenDung {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    protected String createdBy;
    protected Integer idDktd;
    protected boolean isActive;
    protected String madmdktd;
    protected String tendmdktd;

    /**
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the idDktd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdDktd() {
        return idDktd;
    }

    /**
     * Sets the value of the idDktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdDktd(Integer value) {
        this.idDktd = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the madmdktd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMadmdktd() {
        return madmdktd;
    }

    /**
     * Sets the value of the madmdktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMadmdktd(String value) {
        this.madmdktd = value;
    }

    /**
     * Gets the value of the tendmdktd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTendmdktd() {
        return tendmdktd;
    }

    /**
     * Sets the value of the tendmdktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTendmdktd(String value) {
        this.tendmdktd = value;
    }

}
