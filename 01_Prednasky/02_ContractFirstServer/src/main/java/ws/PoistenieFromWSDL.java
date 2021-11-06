package ws;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;


@WebService(serviceName = "PoistenieWSDLService", 
        portName = "PoistenieWSDLPort", 
        endpointInterface = "ws.PoistenieWSDLPortType", 
        targetNamespace = "http://ws/", 
        wsdlLocation = "WEB-INF/wsdl/PoistenieWSDL.wsdl")
public class PoistenieFromWSDL {

    public ws.Zmluva hladaj(java.lang.String cisloZmluvy) {
        try {
            Osoba osoba = new Osoba();
            osoba.setId("10");
            osoba.setMeno("Jozo Mrkvicka");
            
            GregorianCalendar c = new GregorianCalendar();
            osoba.setDatumNar(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
            
            
            Zmluva zml = new Zmluva();
            zml.setCislo(cisloZmluvy);
            zml.setDruh(DruhPoisteniaEnum.ZIVOTNE);
            zml.setPoistnaSuma(33.50f);
            zml.setMajitel(osoba);
            zml.getPoistenci().add(osoba);
            
            return zml;
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(PoistenieFromWSDL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
