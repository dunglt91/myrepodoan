
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tlu30LpvDelete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tlu30LpvDelete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idLpv" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tlu30LpvDelete", propOrder = {
    "idLpv"
})
public class Tlu30LpvDelete {

    protected int idLpv;

    /**
     * Gets the value of the idLpv property.
     * 
     */
    public int getIdLpv() {
        return idLpv;
    }

    /**
     * Sets the value of the idLpv property.
     * 
     */
    public void setIdLpv(int value) {
        this.idLpv = value;
    }

}
