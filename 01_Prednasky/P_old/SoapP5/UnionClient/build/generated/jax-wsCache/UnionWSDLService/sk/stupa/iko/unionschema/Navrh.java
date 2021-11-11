
package sk.stupa.iko.unionschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Navrh complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Navrh">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typ" type="{http://iko.stupa.sk/UnionSchema}TypPoistenia"/>
 *         &lt;element name="poistne" type="{http://iko.stupa.sk/UnionSchema}KladneCisloType" minOccurs="0"/>
 *         &lt;element name="vlastnik" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;element name="poistenec" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded"/>
 *         &lt;element name="ucastnik" type="{http://iko.stupa.sk/UnionSchema}Osoba" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Navrh", propOrder = {
    "typ",
    "poistne",
    "vlastnik",
    "poistenec",
    "ucastnik"
})
@XmlSeeAlso({
    Zmluva.class
})
public class Navrh {

    @XmlElement(required = true)
    protected TypPoistenia typ;
    protected Float poistne;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object vlastnik;
    @XmlElementRef(name = "poistenec", namespace = "http://iko.stupa.sk/UnionSchema", type = JAXBElement.class)
    protected List<JAXBElement<Object>> poistenec;
    @XmlElement(required = true)
    protected List<Osoba> ucastnik;

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link TypPoistenia }
     *     
     */
    public TypPoistenia getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypPoistenia }
     *     
     */
    public void setTyp(TypPoistenia value) {
        this.typ = value;
    }

    /**
     * Gets the value of the poistne property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPoistne() {
        return poistne;
    }

    /**
     * Sets the value of the poistne property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPoistne(Float value) {
        this.poistne = value;
    }

    /**
     * Gets the value of the vlastnik property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getVlastnik() {
        return vlastnik;
    }

    /**
     * Sets the value of the vlastnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setVlastnik(Object value) {
        this.vlastnik = value;
    }

    /**
     * Gets the value of the poistenec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poistenec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoistenec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getPoistenec() {
        if (poistenec == null) {
            poistenec = new ArrayList<JAXBElement<Object>>();
        }
        return this.poistenec;
    }

    /**
     * Gets the value of the ucastnik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucastnik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcastnik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Osoba }
     * 
     * 
     */
    public List<Osoba> getUcastnik() {
        if (ucastnik == null) {
            ucastnik = new ArrayList<Osoba>();
        }
        return this.ucastnik;
    }

}
