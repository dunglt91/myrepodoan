
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30hsuvUpdate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30hsuvUpdate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maHoSo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ngayNhanHoSo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keHoachSo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="boPhanDuTuyen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trinhDoVanHoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hoTen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gioiTinh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cmdn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dienThoai" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kinhNghiem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ghiChu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kemSoYeuLyLich" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kemDonXinViec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kemGiayKhamSucKhoe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kemCmd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kemHoKhau" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kemBangCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giayToKhac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30hsuvUpdate", propOrder = {
    "id",
    "createdBy",
    "createdAt",
    "isActive",
    "maHoSo",
    "ngayNhanHoSo",
    "keHoachSo",
    "boPhanDuTuyen",
    "trinhDoVanHoa",
    "hoTen",
    "gioiTinh",
    "cmdn",
    "dienThoai",
    "email",
    "kinhNghiem",
    "ghiChu",
    "kemSoYeuLyLich",
    "kemDonXinViec",
    "kemGiayKhamSucKhoe",
    "kemCmd",
    "kemHoKhau",
    "kemBangCap",
    "giayToKhac"
})
public class Tlu30HsuvUpdate {

    protected int id;
    protected String createdBy;
    protected String createdAt;
    protected boolean isActive;
    protected String maHoSo;
    protected String ngayNhanHoSo;
    protected String keHoachSo;
    protected String boPhanDuTuyen;
    protected String trinhDoVanHoa;
    protected String hoTen;
    protected String gioiTinh;
    protected int cmdn;
    protected int dienThoai;
    protected String email;
    protected String kinhNghiem;
    protected String ghiChu;
    protected String kemSoYeuLyLich;
    protected String kemDonXinViec;
    protected String kemGiayKhamSucKhoe;
    protected String kemCmd;
    protected String kemHoKhau;
    protected String kemBangCap;
    protected String giayToKhac;

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
     * Gets the value of the maHoSo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaHoSo() {
        return maHoSo;
    }

    /**
     * Sets the value of the maHoSo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaHoSo(String value) {
        this.maHoSo = value;
    }

    /**
     * Gets the value of the ngayNhanHoSo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNgayNhanHoSo() {
        return ngayNhanHoSo;
    }

    /**
     * Sets the value of the ngayNhanHoSo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNgayNhanHoSo(String value) {
        this.ngayNhanHoSo = value;
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
     * Gets the value of the boPhanDuTuyen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoPhanDuTuyen() {
        return boPhanDuTuyen;
    }

    /**
     * Sets the value of the boPhanDuTuyen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoPhanDuTuyen(String value) {
        this.boPhanDuTuyen = value;
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
     * Gets the value of the hoTen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * Sets the value of the hoTen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoTen(String value) {
        this.hoTen = value;
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
     * Gets the value of the cmdn property.
     * 
     */
    public int getCmdn() {
        return cmdn;
    }

    /**
     * Sets the value of the cmdn property.
     * 
     */
    public void setCmdn(int value) {
        this.cmdn = value;
    }

    /**
     * Gets the value of the dienThoai property.
     * 
     */
    public int getDienThoai() {
        return dienThoai;
    }

    /**
     * Sets the value of the dienThoai property.
     * 
     */
    public void setDienThoai(int value) {
        this.dienThoai = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * Gets the value of the kemSoYeuLyLich property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKemSoYeuLyLich() {
        return kemSoYeuLyLich;
    }

    /**
     * Sets the value of the kemSoYeuLyLich property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKemSoYeuLyLich(String value) {
        this.kemSoYeuLyLich = value;
    }

    /**
     * Gets the value of the kemDonXinViec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKemDonXinViec() {
        return kemDonXinViec;
    }

    /**
     * Sets the value of the kemDonXinViec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKemDonXinViec(String value) {
        this.kemDonXinViec = value;
    }

    /**
     * Gets the value of the kemGiayKhamSucKhoe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKemGiayKhamSucKhoe() {
        return kemGiayKhamSucKhoe;
    }

    /**
     * Sets the value of the kemGiayKhamSucKhoe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKemGiayKhamSucKhoe(String value) {
        this.kemGiayKhamSucKhoe = value;
    }

    /**
     * Gets the value of the kemCmd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKemCmd() {
        return kemCmd;
    }

    /**
     * Sets the value of the kemCmd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKemCmd(String value) {
        this.kemCmd = value;
    }

    /**
     * Gets the value of the kemHoKhau property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKemHoKhau() {
        return kemHoKhau;
    }

    /**
     * Sets the value of the kemHoKhau property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKemHoKhau(String value) {
        this.kemHoKhau = value;
    }

    /**
     * Gets the value of the kemBangCap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKemBangCap() {
        return kemBangCap;
    }

    /**
     * Sets the value of the kemBangCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKemBangCap(String value) {
        this.kemBangCap = value;
    }

    /**
     * Gets the value of the giayToKhac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiayToKhac() {
        return giayToKhac;
    }

    /**
     * Sets the value of the giayToKhac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiayToKhac(String value) {
        this.giayToKhac = value;
    }

}
