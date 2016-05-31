
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu20ChucVuFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu20ChucVuFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "tlu20ChucVuFindCommon", propOrder = {
    "tenchucvu",
    "machucvu"
})
public class Tlu20ChucVuFindCommon {

    protected String tenchucvu;
    protected String machucvu;

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
