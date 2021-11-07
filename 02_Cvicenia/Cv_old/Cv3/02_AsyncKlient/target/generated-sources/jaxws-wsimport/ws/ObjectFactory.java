
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

    private final static QName _FindNextPrime_QNAME = new QName("http://ws/", "findNextPrime");
    private final static QName _FindNextPrimeResponse_QNAME = new QName("http://ws/", "findNextPrimeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindNextPrime }
     * 
     */
    public FindNextPrime createFindNextPrime() {
        return new FindNextPrime();
    }

    /**
     * Create an instance of {@link FindNextPrimeResponse }
     * 
     */
    public FindNextPrimeResponse createFindNextPrimeResponse() {
        return new FindNextPrimeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindNextPrime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findNextPrime")
    public JAXBElement<FindNextPrime> createFindNextPrime(FindNextPrime value) {
        return new JAXBElement<FindNextPrime>(_FindNextPrime_QNAME, FindNextPrime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindNextPrimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findNextPrimeResponse")
    public JAXBElement<FindNextPrimeResponse> createFindNextPrimeResponse(FindNextPrimeResponse value) {
        return new JAXBElement<FindNextPrimeResponse>(_FindNextPrimeResponse_QNAME, FindNextPrimeResponse.class, null, value);
    }

}
