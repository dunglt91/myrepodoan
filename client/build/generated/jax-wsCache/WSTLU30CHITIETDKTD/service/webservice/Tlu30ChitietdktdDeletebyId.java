
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30chitietdktdDeletebyId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30chitietdktdDeletebyId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iddktd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30chitietdktdDeletebyId", propOrder = {
    "iddktd"
})
public class Tlu30ChitietdktdDeletebyId {

    protected int iddktd;

    /**
     * Gets the value of the iddktd property.
     * 
     */
    public int getIddktd() {
        return iddktd;
    }

    /**
     * Sets the value of the iddktd property.
     * 
     */
    public void setIddktd(int value) {
        this.iddktd = value;
    }

}
