
package sk.stupa.iko.unionschema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sk.stupa.iko.unionschema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VytvorOut_QNAME = new QName("http://iko.stupa.sk/UnionSchema", "vytvor-out");
    private final static QName _HladajVstup_QNAME = new QName("http://iko.stupa.sk/UnionSchema", "hladaj-vstup");
    private final static QName _HladajVystup_QNAME = new QName("http://iko.stupa.sk/UnionSchema", "hladaj-vystup");
    private final static QName _VytvorIn_QNAME = new QName("http://iko.stupa.sk/UnionSchema", "vytvor-in");
    private final static QName _NavrhPoistenec_QNAME = new QName("http://iko.stupa.sk/UnionSchema", "poistenec");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sk.stupa.iko.unionschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Navrh }
     * 
     */
    public Navrh createNavrh() {
        return new Navrh();
    }

    /**
     * Create an instance of {@link Zmluva }
     * 
     */
    public Zmluva createZmluva() {
        return new Zmluva();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Osoba }
     * 
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zmluva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iko.stupa.sk/UnionSchema", name = "vytvor-out")
    public JAXBElement<Zmluva> createVytvorOut(Zmluva value) {
        return new JAXBElement<Zmluva>(_VytvorOut_QNAME, Zmluva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iko.stupa.sk/UnionSchema", name = "hladaj-vstup")
    public JAXBElement<String> createHladajVstup(String value) {
        return new JAXBElement<String>(_HladajVstup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Navrh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iko.stupa.sk/UnionSchema", name = "hladaj-vystup")
    public JAXBElement<Navrh> createHladajVystup(Navrh value) {
        return new JAXBElement<Navrh>(_HladajVystup_QNAME, Navrh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Navrh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iko.stupa.sk/UnionSchema", name = "vytvor-in")
    public JAXBElement<Navrh> createVytvorIn(Navrh value) {
        return new JAXBElement<Navrh>(_VytvorIn_QNAME, Navrh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iko.stupa.sk/UnionSchema", name = "poistenec", scope = Navrh.class)
    @XmlIDREF
    public JAXBElement<Object> createNavrhPoistenec(Object value) {
        return new JAXBElement<Object>(_NavrhPoistenec_QNAME, Object.class, Navrh.class, value);
    }

}
