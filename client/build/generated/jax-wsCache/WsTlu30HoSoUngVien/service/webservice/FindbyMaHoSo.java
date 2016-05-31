
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FindbyMaHoSo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FindbyMaHoSo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mhs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindbyMaHoSo", propOrder = {
    "mhs"
})
public class FindbyMaHoSo {

    protected String mhs;

    /**
     * Gets the value of the mhs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMhs() {
        return mhs;
    }

    /**
     * Sets the value of the mhs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMhs(String value) {
        this.mhs = value;
    }

}
