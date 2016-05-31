
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu20TrinhDoVanHoaFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu20TrinhDoVanHoaFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenTDVH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maTDVH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu20TrinhDoVanHoaFindCommon", propOrder = {
    "tenTDVH",
    "maTDVH"
})
public class Tlu20TrinhDoVanHoaFindCommon {

    protected String tenTDVH;
    protected String maTDVH;

    /**
     * Gets the value of the tenTDVH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenTDVH() {
        return tenTDVH;
    }

    /**
     * Sets the value of the tenTDVH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenTDVH(String value) {
        this.tenTDVH = value;
    }

    /**
     * Gets the value of the maTDVH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaTDVH() {
        return maTDVH;
    }

    /**
     * Sets the value of the maTDVH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaTDVH(String value) {
        this.maTDVH = value;
    }

}
