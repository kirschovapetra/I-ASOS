
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for odstranJedlo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="odstranJedlo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nazov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "odstranJedlo", propOrder = {
    "nazov"
})
public class OdstranJedlo {

    protected String nazov;

    /**
     * Gets the value of the nazov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazov() {
        return nazov;
    }

    /**
     * Sets the value of the nazov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazov(String value) {
        this.nazov = value;
    }

}
