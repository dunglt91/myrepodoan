
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tlu30KeHoachTuyenDung complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu30KeHoachTuyenDung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boPhan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chucVu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ghiChu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gioiTinh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idKhtd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="keHoachSo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kinhNghiem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ngayKeHoach" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="noiLamViec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soLuong" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="trinhDoVanHoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tuoiMax" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tuoiMin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu30KeHoachTuyenDung", propOrder = {
    "boPhan",
    "chucVu",
    "createdAt",
    "createdBy",
    "ghiChu",
    "gioiTinh",
    "idKhtd",
    "isActive",
    "keHoachSo",
    "kinhNghiem",
    "ngayKeHoach",
    "noiLamViec",
    "soLuong",
    "trinhDoVanHoa",
    "tuoiMax",
    "tuoiMin"
})
public class Tlu30KeHoachTuyenDung {

    protected String boPhan;
    protected String chucVu;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    protected String createdBy;
    protected String ghiChu;
    protected String gioiTinh;
    protected Integer idKhtd;
    protected boolean isActive;
    protected String keHoachSo;
    protected String kinhNghiem;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ngayKeHoach;
    protected String noiLamViec;
    protected int soLuong;
    protected String trinhDoVanHoa;
    protected int tuoiMax;
    protected int tuoiMin;

    /**
     * Gets the value of the boPhan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * Sets the value of the boPhan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoPhan(String value) {
        this.boPhan = value;
    }

    /**
     * Gets the value of the chucVu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChucVu() {
        return chucVu;
    }

    /**
     * Sets the value of the chucVu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChucVu(String value) {
        this.chucVu = value;
    }

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
     * Gets the value of the ghiChu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * Sets the value of the ghiChu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGhiChu(String value) {
        this.ghiChu = value;
    }

    /**
     * Gets the value of the gioiTinh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * Sets the value of the gioiTinh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGioiTinh(String value) {
        this.gioiTinh = value;
    }

    /**
     * Gets the value of the idKhtd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdKhtd() {
        return idKhtd;
    }

    /**
     * Sets the value of the idKhtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdKhtd(Integer value) {
        this.idKhtd = value;
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
     * Gets the value of the kinhNghiem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKinhNghiem() {
        return kinhNghiem;
    }

    /**
     * Sets the value of the kinhNghiem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKinhNghiem(String value) {
        this.kinhNghiem = value;
    }

    /**
     * Gets the value of the ngayKeHoach property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNgayKeHoach() {
        return ngayKeHoach;
    }

    /**
     * Sets the value of the ngayKeHoach property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNgayKeHoach(XMLGregorianCalendar value) {
        this.ngayKeHoach = value;
    }

    /**
     * Gets the value of the noiLamViec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoiLamViec() {
        return noiLamViec;
    }

    /**
     * Sets the value of the noiLamViec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoiLamViec(String value) {
        this.noiLamViec = value;
    }

    /**
     * Gets the value of the soLuong property.
     * 
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * Sets the value of the soLuong property.
     * 
     */
    public void setSoLuong(int value) {
        this.soLuong = value;
    }

    /**
     * Gets the value of the trinhDoVanHoa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrinhDoVanHoa() {
        return trinhDoVanHoa;
    }

    /**
     * Sets the value of the trinhDoVanHoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrinhDoVanHoa(String value) {
        this.trinhDoVanHoa = value;
    }

    /**
     * Gets the value of the tuoiMax property.
     * 
     */
    public int getTuoiMax() {
        return tuoiMax;
    }

    /**
     * Sets the value of the tuoiMax property.
     * 
     */
    public void setTuoiMax(int value) {
        this.tuoiMax = value;
    }

    /**
     * Gets the value of the tuoiMin property.
     * 
     */
    public int getTuoiMin() {
        return tuoiMin;
    }

    /**
     * Sets the value of the tuoiMin property.
     * 
     */
    public void setTuoiMin(int value) {
        this.tuoiMin = value;
    }

}
