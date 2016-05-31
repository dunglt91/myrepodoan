
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu20BoPhanInsert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu20BoPhanInsert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Tenbophan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Mabophan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu20BoPhanInsert", propOrder = {
    "createdBy",
    "createdAt",
    "isActive",
    "tenbophan",
    "mabophan"
})
public class Tlu20BoPhanInsert {

    protected String createdBy;
    protected String createdAt;
    protected boolean isActive;
    @XmlElement(name = "Tenbophan")
    protected String tenbophan;
    @XmlElement(name = "Mabophan")
    protected String mabophan;

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
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedAt(String value) {
        this.createdAt = value;
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
     * Gets the value of the tenbophan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenbophan() {
        return tenbophan;
    }

    /**
     * Sets the value of the tenbophan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenbophan(String value) {
        this.tenbophan = value;
    }

    /**
     * Gets the value of the mabophan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMabophan() {
        return mabophan;
    }

    /**
     * Sets the value of the mabophan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMabophan(String value) {
        this.mabophan = value;
    }

}
