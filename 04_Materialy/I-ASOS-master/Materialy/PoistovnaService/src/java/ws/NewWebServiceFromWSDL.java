/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.netbeans.xml.schema.poistovna.Osoba;
import org.netbeans.xml.schema.poistovna.PoistnaZmluva;

/**
 *
 * @author vsa
 */
@WebService(serviceName = "podatNavrhService", portName = "podatNavrhPort", endpointInterface = "org.netbeans.j2ee.wsdl.postiovnaschema.schema.podatnavrh.PodatNavrhPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/PostiovnaSchema/schema/podatNavrh", wsdlLocation = "WEB-INF/wsdl/NewWebServiceFromWSDL/podatNavrh.wsdl")
public class NewWebServiceFromWSDL {

    public org.netbeans.xml.schema.poistovna.PoistnaZmluva podatNavrh(org.netbeans.xml.schema.poistovna.NavrhZmluvy navrh) {
        //TODO implement this method
        PoistnaZmluva ret = new PoistnaZmluva();
        
        ret.setDruh(navrh.getDruh());
        
        List<Osoba> poistenci = navrh.getUcastnikZmluvy();
        for(Osoba o : poistenci){
         ret.getUcastnikZmluvy().add(o);
        }
        
        for(Object o : navrh.getPoistnik()){
            Osoba buf = (Osoba) o;
            System.out.println("Jeblina: "+ buf.getId());
            ret.getPoistnik().add((Object) buf);
        }
        
        return ret;
    }
    
}
