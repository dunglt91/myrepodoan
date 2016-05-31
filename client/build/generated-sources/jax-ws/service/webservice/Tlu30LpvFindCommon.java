
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu30LpvFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu30LpvFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maHs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Khs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenUngVien" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatYeuCau" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu30LpvFindCommon", propOrder = {
    "maHs",
    "khs",
    "tenUngVien",
    "datYeuCau"
})
public class Tlu30LpvFindCommon {

    protected String maHs;
    @XmlElement(name = "Khs")
    protected String khs;
    protected String tenUngVien;
    @XmlElement(name = "DatYeuCau")
    protected String datYeuCau;

    /**
     * Gets the value of the maHs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaHs() {
        return maHs;
    }

    /**
     * Sets the value of the maHs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaHs(String value) {
        this.maHs = value;
    }

    /**
     * Gets the value of the khs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKhs() {
        return khs;
    }

    /**
     * Sets the value of the khs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKhs(String value) {
        this.khs = value;
    }

    /**
     * Gets the value of the tenUngVien property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenUngVien() {
        return tenUngVien;
    }

    /**
     * Sets the value of the tenUngVien property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenUngVien(String value) {
        this.tenUngVien = value;
    }

    /**
     * Gets the value of the datYeuCau property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatYeuCau() {
        return datYeuCau;
    }

    /**
     * Sets the value of the datYeuCau property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatYeuCau(String value) {
        this.datYeuCau = value;
    }

}
