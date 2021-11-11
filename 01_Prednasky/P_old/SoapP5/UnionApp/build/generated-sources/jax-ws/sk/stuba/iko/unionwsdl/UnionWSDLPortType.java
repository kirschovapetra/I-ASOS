
package sk.stuba.iko.unionwsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import sk.stupa.iko.unionschema.Navrh;
import sk.stupa.iko.unionschema.ObjectFactory;
import sk.stupa.iko.unionschema.Zmluva;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UnionWSDLPortType", targetNamespace = "http://iko.stuba.sk/UnionWSDL")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UnionWSDLPortType {


    /**
     * 
     * @param cislo
     * @return
     *     returns sk.stupa.iko.unionschema.Navrh
     */
    @WebMethod
    @WebResult(name = "hladaj-vystup", targetNamespace = "http://iko.stupa.sk/UnionSchema", partName = "return")
    public Navrh hladaj(
        @WebParam(name = "hladaj-vstup", targetNamespace = "http://iko.stupa.sk/UnionSchema", partName = "cislo")
        String cislo);

    /**
     * 
     * @param navrh
     * @return
     *     returns sk.stupa.iko.unionschema.Zmluva
     */
    @WebMethod
    @WebResult(name = "vytvor-out", targetNamespace = "http://iko.stupa.sk/UnionSchema", partName = "return")
    public Zmluva vytvor(
        @WebParam(name = "vytvor-in", targetNamespace = "http://iko.stupa.sk/UnionSchema", partName = "navrh")
        Navrh navrh);

}
