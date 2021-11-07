
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
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

    private final static QName _PocetJedalResponse_QNAME = new QName("http://ws/", "pocetJedalResponse");
    private final static QName _ZmenPopisResponse_QNAME = new QName("http://ws/", "zmenPopisResponse");
    private final static QName _VytvorJedlo_QNAME = new QName("http://ws/", "vytvorJedlo");
    private final static QName _PocetJedal_QNAME = new QName("http://ws/", "pocetJedal");
    private final static QName _InfoResponse_QNAME = new QName("http://ws/", "infoResponse");
    private final static QName _Exception_QNAME = new QName("http://ws/", "Exception");
    private final static QName _Ponuka_QNAME = new QName("http://ws/", "ponuka");
    private final static QName _OdstranJedlo_QNAME = new QName("http://ws/", "odstranJedlo");
    private final static QName _PonukaResponse_QNAME = new QName("http://ws/", "ponukaResponse");
    private final static QName _ZmenCenuResponse_QNAME = new QName("http://ws/", "zmenCenuResponse");
    private final static QName _ZmenCenu_QNAME = new QName("http://ws/", "zmenCenu");
    private final static QName _ZmenPopis_QNAME = new QName("http://ws/", "zmenPopis");
    private final static QName _Info_QNAME = new QName("http://ws/", "info");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PocetJedalResponse }
     * 
     */
    public PocetJedalResponse createPocetJedalResponse() {
        return new PocetJedalResponse();
    }

    /**
     * Create an instance of {@link ZmenPopisResponse }
     * 
     */
    public ZmenPopisResponse createZmenPopisResponse() {
        return new ZmenPopisResponse();
    }

    /**
     * Create an instance of {@link VytvorJedlo }
     * 
     */
    public VytvorJedlo createVytvorJedlo() {
        return new VytvorJedlo();
    }

    /**
     * Create an instance of {@link PocetJedal }
     * 
     */
    public PocetJedal createPocetJedal() {
        return new PocetJedal();
    }

    /**
     * Create an instance of {@link InfoResponse }
     * 
     */
    public InfoResponse createInfoResponse() {
        return new InfoResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Ponuka }
     * 
     */
    public Ponuka createPonuka() {
        return new Ponuka();
    }

    /**
     * Create an instance of {@link OdstranJedlo }
     * 
     */
    public OdstranJedlo createOdstranJedlo() {
        return new OdstranJedlo();
    }

    /**
     * Create an instance of {@link PonukaResponse }
     * 
     */
    public PonukaResponse createPonukaResponse() {
        return new PonukaResponse();
    }

    /**
     * Create an instance of {@link ZmenCenuResponse }
     * 
     */
    public ZmenCenuResponse createZmenCenuResponse() {
        return new ZmenCenuResponse();
    }

    /**
     * Create an instance of {@link ZmenCenu }
     * 
     */
    public ZmenCenu createZmenCenu() {
        return new ZmenCenu();
    }

    /**
     * Create an instance of {@link ZmenPopis }
     * 
     */
    public ZmenPopis createZmenPopis() {
        return new ZmenPopis();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link Jedlo }
     * 
     */
    public Jedlo createJedlo() {
        return new Jedlo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PocetJedalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "pocetJedalResponse")
    public JAXBElement<PocetJedalResponse> createPocetJedalResponse(PocetJedalResponse value) {
        return new JAXBElement<PocetJedalResponse>(_PocetJedalResponse_QNAME, PocetJedalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZmenPopisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "zmenPopisResponse")
    public JAXBElement<ZmenPopisResponse> createZmenPopisResponse(ZmenPopisResponse value) {
        return new JAXBElement<ZmenPopisResponse>(_ZmenPopisResponse_QNAME, ZmenPopisResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VytvorJedlo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "vytvorJedlo")
    public JAXBElement<VytvorJedlo> createVytvorJedlo(VytvorJedlo value) {
        return new JAXBElement<VytvorJedlo>(_VytvorJedlo_QNAME, VytvorJedlo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PocetJedal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "pocetJedal")
    public JAXBElement<PocetJedal> createPocetJedal(PocetJedal value) {
        return new JAXBElement<PocetJedal>(_PocetJedal_QNAME, PocetJedal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "infoResponse")
    public JAXBElement<InfoResponse> createInfoResponse(InfoResponse value) {
        return new JAXBElement<InfoResponse>(_InfoResponse_QNAME, InfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ponuka }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "ponuka")
    public JAXBElement<Ponuka> createPonuka(Ponuka value) {
        return new JAXBElement<Ponuka>(_Ponuka_QNAME, Ponuka.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdstranJedlo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "odstranJedlo")
    public JAXBElement<OdstranJedlo> createOdstranJedlo(OdstranJedlo value) {
        return new JAXBElement<OdstranJedlo>(_OdstranJedlo_QNAME, OdstranJedlo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PonukaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "ponukaResponse")
    public JAXBElement<PonukaResponse> createPonukaResponse(PonukaResponse value) {
        return new JAXBElement<PonukaResponse>(_PonukaResponse_QNAME, PonukaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZmenCenuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "zmenCenuResponse")
    public JAXBElement<ZmenCenuResponse> createZmenCenuResponse(ZmenCenuResponse value) {
        return new JAXBElement<ZmenCenuResponse>(_ZmenCenuResponse_QNAME, ZmenCenuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZmenCenu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "zmenCenu")
    public JAXBElement<ZmenCenu> createZmenCenu(ZmenCenu value) {
        return new JAXBElement<ZmenCenu>(_ZmenCenu_QNAME, ZmenCenu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZmenPopis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "zmenPopis")
    public JAXBElement<ZmenPopis> createZmenPopis(ZmenPopis value) {
        return new JAXBElement<ZmenPopis>(_ZmenPopis_QNAME, ZmenPopis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Info }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "info")
    public JAXBElement<Info> createInfo(Info value) {
        return new JAXBElement<Info>(_Info_QNAME, Info.class, null, value);
    }

}
