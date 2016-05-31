
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu20DktdInsert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu20DktdInsert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdby" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isactive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "tlu20DktdInsert", propOrder = {
    "createdby",
    "createdat",
    "isactive",
    "madmdktd",
    "tendmdktd"
})
public class Tlu20DktdInsert {

    protected String createdby;
    protected String createdat;
    protected boolean isactive;
    protected String madmdktd;
    protected String tendmdktd;

    /**
     * Gets the value of the createdby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedby() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedby(String value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the createdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedat() {
        return createdat;
    }

    /**
     * Sets the value of the createdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedat(String value) {
        this.createdat = value;
    }

    /**
     * Gets the value of the isactive property.
     * 
     */
    public boolean isIsactive() {
        return isactive;
    }

    /**
     * Sets the value of the isactive property.
     * 
     */
    public void setIsactive(boolean value) {
        this.isactive = value;
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
