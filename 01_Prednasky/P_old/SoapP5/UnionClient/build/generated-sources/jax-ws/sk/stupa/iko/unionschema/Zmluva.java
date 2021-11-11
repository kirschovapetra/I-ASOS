
package sk.stupa.iko.unionschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Zmluva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Zmluva">
 *   &lt;complexContent>
 *     &lt;extension base="{http://iko.stupa.sk/UnionSchema}Navrh">
 *       &lt;sequence>
 *         &lt;element name="cislo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uzavreta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Zmluva", propOrder = {
    "cislo",
    "uzavreta"
})
public class Zmluva
    extends Navrh
{

    @XmlElement(required = true)
    protected String cislo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar uzavreta;

    /**
     * Gets the value of the cislo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCislo() {
        return cislo;
    }

    /**
     * Sets the value of the cislo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCislo(String value) {
        this.cislo = value;
    }

    /**
     * Gets the value of the uzavreta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUzavreta() {
        return uzavreta;
    }

    /**
     * Sets the value of the uzavreta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUzavreta(XMLGregorianCalendar value) {
        this.uzavreta = value;
    }

}
