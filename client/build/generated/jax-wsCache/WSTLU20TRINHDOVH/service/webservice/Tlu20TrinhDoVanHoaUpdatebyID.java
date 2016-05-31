
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu20TrinhDoVanHoaUpdatebyID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu20TrinhDoVanHoaUpdatebyID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="tenchucvu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="machucvu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu20TrinhDoVanHoaUpdatebyID", propOrder = {
    "id",
    "createdBy",
    "createdAt",
    "isActive",
    "tenchucvu",
    "machucvu"
})
public class Tlu20TrinhDoVanHoaUpdatebyID {

    protected int id;
    protected String createdBy;
    protected String createdAt;
    protected boolean isActive;
    protected String tenchucvu;
    protected String machucvu;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
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
     * Gets the value of the tenchucvu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenchucvu() {
        return tenchucvu;
    }

    /**
     * Sets the value of the tenchucvu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenchucvu(String value) {
        this.tenchucvu = value;
    }

    /**
     * Gets the value of the machucvu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachucvu() {
        return machucvu;
    }

    /**
     * Sets the value of the machucvu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachucvu(String value) {
        this.machucvu = value;
    }

}
