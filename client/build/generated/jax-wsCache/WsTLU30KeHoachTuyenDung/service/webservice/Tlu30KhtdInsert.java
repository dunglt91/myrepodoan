
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30khtdInsert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30khtdInsert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdby" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isactive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="kehoachso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ngaykehoach" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bophan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chucvu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trinhdovanhoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soluong" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gioitinh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tuoimin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tuoimax" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="noilamviec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kinhnghiem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ghichu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30khtdInsert", propOrder = {
    "createdby",
    "createdat",
    "isactive",
    "kehoachso",
    "ngaykehoach",
    "bophan",
    "chucvu",
    "trinhdovanhoa",
    "soluong",
    "gioitinh",
    "tuoimin",
    "tuoimax",
    "noilamviec",
    "kinhnghiem",
    "ghichu"
})
public class Tlu30KhtdInsert {

    protected String createdby;
    protected String createdat;
    protected boolean isactive;
    protected String kehoachso;
    protected String ngaykehoach;
    protected String bophan;
    protected String chucvu;
    protected String trinhdovanhoa;
    protected int soluong;
    protected String gioitinh;
    protected int tuoimin;
    protected int tuoimax;
    protected String noilamviec;
    protected String kinhnghiem;
    protected String ghichu;

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
     * Gets the value of the kehoachso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKehoachso() {
        return kehoachso;
    }

    /**
     * Sets the value of the kehoachso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKehoachso(String value) {
        this.kehoachso = value;
    }

    /**
     * Gets the value of the ngaykehoach property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNgaykehoach() {
        return ngaykehoach;
    }

    /**
     * Sets the value of the ngaykehoach property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNgaykehoach(String value) {
        this.ngaykehoach = value;
    }

    /**
     * Gets the value of the bophan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBophan() {
        return bophan;
    }

    /**
     * Sets the value of the bophan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBophan(String value) {
        this.bophan = value;
    }

    /**
     * Gets the value of the chucvu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChucvu() {
        return chucvu;
    }

    /**
     * Sets the value of the chucvu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChucvu(String value) {
        this.chucvu = value;
    }

    /**
     * Gets the value of the trinhdovanhoa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrinhdovanhoa() {
        return trinhdovanhoa;
    }

    /**
     * Sets the value of the trinhdovanhoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrinhdovanhoa(String value) {
        this.trinhdovanhoa = value;
    }

    /**
     * Gets the value of the soluong property.
     * 
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * Sets the value of the soluong property.
     * 
     */
    public void setSoluong(int value) {
        this.soluong = value;
    }

    /**
     * Gets the value of the gioitinh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGioitinh() {
        return gioitinh;
    }

    /**
     * Sets the value of the gioitinh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGioitinh(String value) {
        this.gioitinh = value;
    }

    /**
     * Gets the value of the tuoimin property.
     * 
     */
    public int getTuoimin() {
        return tuoimin;
    }

    /**
     * Sets the value of the tuoimin property.
     * 
     */
    public void setTuoimin(int value) {
        this.tuoimin = value;
    }

    /**
     * Gets the value of the tuoimax property.
     * 
     */
    public int getTuoimax() {
        return tuoimax;
    }

    /**
     * Sets the value of the tuoimax property.
     * 
     */
    public void setTuoimax(int value) {
        this.tuoimax = value;
    }

    /**
     * Gets the value of the noilamviec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoilamviec() {
        return noilamviec;
    }

    /**
     * Sets the value of the noilamviec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoilamviec(String value) {
        this.noilamviec = value;
    }

    /**
     * Gets the value of the kinhnghiem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKinhnghiem() {
        return kinhnghiem;
    }

    /**
     * Sets the value of the kinhnghiem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKinhnghiem(String value) {
        this.kinhnghiem = value;
    }

    /**
     * Gets the value of the ghichu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGhichu() {
        return ghichu;
    }

    /**
     * Sets the value of the ghichu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGhichu(String value) {
        this.ghichu = value;
    }

}
