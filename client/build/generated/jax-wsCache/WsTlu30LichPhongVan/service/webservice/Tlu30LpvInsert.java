
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30LpvInsert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30LpvInsert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ungVien" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keHoachSo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soLichPhongVan" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lichHen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phuTrachPhongVan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tinhTrangPhongVan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datYeuCau" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nhanXet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30LpvInsert", propOrder = {
    "createdBy",
    "createdAt",
    "isActive",
    "ungVien",
    "keHoachSo",
    "soLichPhongVan",
    "lichHen",
    "phuTrachPhongVan",
    "tinhTrangPhongVan",
    "datYeuCau",
    "nhanXet"
})
public class Tlu30LpvInsert {

    protected String createdBy;
    protected String createdAt;
    protected boolean isActive;
    protected String ungVien;
    protected String keHoachSo;
    protected int soLichPhongVan;
    protected String lichHen;
    protected String phuTrachPhongVan;
    protected String tinhTrangPhongVan;
    protected boolean datYeuCau;
    protected String nhanXet;

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
     * Gets the value of the ungVien property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUngVien() {
        return ungVien;
    }

    /**
     * Sets the value of the ungVien property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUngVien(String value) {
        this.ungVien = value;
    }

    /**
     * Gets the value of the keHoachSo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeHoachSo() {
        return keHoachSo;
    }

    /**
     * Sets the value of the keHoachSo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeHoachSo(String value) {
        this.keHoachSo = value;
    }

    /**
     * Gets the value of the soLichPhongVan property.
     * 
     */
    public int getSoLichPhongVan() {
        return soLichPhongVan;
    }

    /**
     * Sets the value of the soLichPhongVan property.
     * 
     */
    public void setSoLichPhongVan(int value) {
        this.soLichPhongVan = value;
    }

    /**
     * Gets the value of the lichHen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLichHen() {
        return lichHen;
    }

    /**
     * Sets the value of the lichHen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLichHen(String value) {
        this.lichHen = value;
    }

    /**
     * Gets the value of the phuTrachPhongVan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhuTrachPhongVan() {
        return phuTrachPhongVan;
    }

    /**
     * Sets the value of the phuTrachPhongVan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhuTrachPhongVan(String value) {
        this.phuTrachPhongVan = value;
    }

    /**
     * Gets the value of the tinhTrangPhongVan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTinhTrangPhongVan() {
        return tinhTrangPhongVan;
    }

    /**
     * Sets the value of the tinhTrangPhongVan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTinhTrangPhongVan(String value) {
        this.tinhTrangPhongVan = value;
    }

    /**
     * Gets the value of the datYeuCau property.
     * 
     */
    public boolean isDatYeuCau() {
        return datYeuCau;
    }

    /**
     * Sets the value of the datYeuCau property.
     * 
     */
    public void setDatYeuCau(boolean value) {
        this.datYeuCau = value;
    }

    /**
     * Gets the value of the nhanXet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNhanXet() {
        return nhanXet;
    }

    /**
     * Sets the value of the nhanXet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNhanXet(String value) {
        this.nhanXet = value;
    }

}
