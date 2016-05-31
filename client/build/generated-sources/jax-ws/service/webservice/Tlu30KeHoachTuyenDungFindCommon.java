
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30keHoachTuyenDungFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30keHoachTuyenDungFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keHoachSo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chucVu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="boPhan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30keHoachTuyenDungFindCommon", propOrder = {
    "keHoachSo",
    "chucVu",
    "boPhan"
})
public class Tlu30KeHoachTuyenDungFindCommon {

    protected String keHoachSo;
    protected String chucVu;
    protected String boPhan;

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

}
