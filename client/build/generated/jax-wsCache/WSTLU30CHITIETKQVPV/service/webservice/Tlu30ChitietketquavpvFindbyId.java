
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30chitietketquavpvFindbyId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30chitietketquavpvFindbyId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTlu30chitietketquavpv" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30chitietketquavpvFindbyId", propOrder = {
    "idTlu30Chitietketquavpv"
})
public class Tlu30ChitietketquavpvFindbyId {

    @XmlElement(name = "idTlu30chitietketquavpv")
    protected int idTlu30Chitietketquavpv;

    /**
     * Gets the value of the idTlu30Chitietketquavpv property.
     * 
     */
    public int getIdTlu30Chitietketquavpv() {
        return idTlu30Chitietketquavpv;
    }

    /**
     * Sets the value of the idTlu30Chitietketquavpv property.
     * 
     */
    public void setIdTlu30Chitietketquavpv(int value) {
        this.idTlu30Chitietketquavpv = value;
    }

}
