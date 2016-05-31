
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30khtdFindByKeHoachSo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30khtdFindByKeHoachSo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kehoachso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30khtdFindByKeHoachSo", propOrder = {
    "kehoachso"
})
public class Tlu30KhtdFindByKeHoachSo {

    protected String kehoachso;

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

}
