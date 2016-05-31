
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu30Chitietdktd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu30Chitietdktd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diemcandat" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="kehoachtuyendung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="machitietdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenchitietdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu30Chitietdktd", propOrder = {
    "diemcandat",
    "id",
    "kehoachtuyendung",
    "machitietdktd",
    "tenchitietdktd"
})
public class Tlu30Chitietdktd {

    protected float diemcandat;
    protected Integer id;
    protected String kehoachtuyendung;
    protected String machitietdktd;
    protected String tenchitietdktd;

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
     * Gets the value of the kehoachtuyendung property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKehoachtuyendung() {
        return kehoachtuyendung;
    }

    /**
     * Sets the value of the kehoachtuyendung property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKehoachtuyendung(String value) {
        this.kehoachtuyendung = value;
    }

    /**
     * Gets the value of the machitietdktd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachitietdktd() {
        return machitietdktd;
    }

    /**
     * Sets the value of the machitietdktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachitietdktd(String value) {
        this.machitietdktd = value;
    }

    /**
     * Gets the value of the tenchitietdktd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenchitietdktd() {
        return tenchitietdktd;
    }

    /**
     * Sets the value of the tenchitietdktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenchitietdktd(String value) {
        this.tenchitietdktd = value;
    }

}
