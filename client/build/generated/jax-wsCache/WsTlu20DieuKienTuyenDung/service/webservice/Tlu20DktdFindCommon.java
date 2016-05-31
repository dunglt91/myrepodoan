
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu20DktdFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu20DktdFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tendmdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="madmdktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu20DktdFindCommon", propOrder = {
    "tendmdktd",
    "madmdktd"
})
public class Tlu20DktdFindCommon {

    protected String tendmdktd;
    protected String madmdktd;

    /**
     * Gets the value of the tendmdktd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTendmdktd() {
        return tendmdktd;
    }

    /**
     * Sets the value of the tendmdktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTendmdktd(String value) {
        this.tendmdktd = value;
    }

    /**
     * Gets the value of the madmdktd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMadmdktd() {
        return madmdktd;
    }

    /**
     * Sets the value of the madmdktd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMadmdktd(String value) {
        this.madmdktd = value;
    }

}
