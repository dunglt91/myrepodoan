
package service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tlu30HsuvFindCommon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tlu30HsuvFindCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maHs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Khs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bophan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tlu30HsuvFindCommon", propOrder = {
    "maHs",
    "khs",
    "bophan"
})
public class Tlu30HsuvFindCommon {

    protected String maHs;
    @XmlElement(name = "Khs")
    protected String khs;
    protected String bophan;

    /**
     * Gets the value of the maHs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaHs() {
        return maHs;
    }

    /**
     * Sets the value of the maHs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaHs(String value) {
        this.maHs = value;
    }

    /**
     * Gets the value of the khs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKhs() {
        return khs;
    }

    /**
     * Sets the value of the khs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKhs(String value) {
        this.khs = value;
    }

    /**
     * Gets the value of the bophan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBophan() {
        return bophan;
    }

    /**
     * Sets the value of the bophan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBophan(String value) {
        this.bophan = value;
    }

}
