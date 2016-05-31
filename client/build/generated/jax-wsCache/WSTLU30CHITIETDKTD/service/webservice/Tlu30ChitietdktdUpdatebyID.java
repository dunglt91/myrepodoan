
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30chitietdktdUpdatebyID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30chitietdktdUpdatebyID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iddktd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Kehoachtuyendung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Machitietdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tenchitietdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiemcandatDiemcandat" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30chitietdktdUpdatebyID", propOrder = {
    "iddktd",
    "kehoachtuyendung",
    "machitietdktd",
    "tenchitietdktd",
    "diemcandatDiemcandat"
})
public class Tlu30ChitietdktdUpdatebyID {

    protected int iddktd;
    @XmlElement(name = "Kehoachtuyendung")
    protected String kehoachtuyendung;
    @XmlElement(name = "Machitietdktd")
    protected String machitietdktd;
    @XmlElement(name = "Tenchitietdktd")
    protected String tenchitietdktd;
    @XmlElement(name = "DiemcandatDiemcandat")
    protected float diemcandatDiemcandat;

    /**
     * Gets the value of the iddktd property.
     * 
     */
    public int getIddktd() {
        return iddktd;
    }

    /**
     * Sets the value of the iddktd property.
     * 
     */
    public void setIddktd(int value) {
        this.iddktd = value;
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

    /**
     * Gets the value of the diemcandatDiemcandat property.
     * 
     */
    public float getDiemcandatDiemcandat() {
        return diemcandatDiemcandat;
    }

    /**
     * Sets the value of the diemcandatDiemcandat property.
     * 
     */
    public void setDiemcandatDiemcandat(float value) {
        this.diemcandatDiemcandat = value;
    }

}
