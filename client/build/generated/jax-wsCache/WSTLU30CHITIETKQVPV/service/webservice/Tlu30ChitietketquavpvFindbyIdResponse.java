
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30chitietketquavpvFindbyIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30chitietketquavpvFindbyIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.service/}tlu30Chitietketquavpv" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30chitietketquavpvFindbyIdResponse", propOrder = {
    "_return"
})
public class Tlu30ChitietketquavpvFindbyIdResponse {

    @XmlElement(name = "return")
    protected Tlu30Chitietketquavpv _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link Tlu30Chitietketquavpv }
     *     
     */
    public Tlu30Chitietketquavpv getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tlu30Chitietketquavpv }
     *     
     */
    public void setReturn(Tlu30Chitietketquavpv value) {
        this._return = value;
    }

}
