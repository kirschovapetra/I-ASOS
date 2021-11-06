package ws;

import javax.jws.WebService;

@WebService(serviceName = "PoistenieFromWSDL", portName = "PoistenieFromWSDLPort", endpointInterface = "ws.PoistenieFromWSDL", targetNamespace = "http://ws/", wsdlLocation = "WEB-INF/wsdl/PoistenieFromWSDL.wsdl")
public class Poistenie {
    
    public ws.Zmluva hladaj(java.lang.String cisloZmluvy) {
        
        Osoba osoba = new Osoba();
        osoba.setId("jozkoMaId10");
        osoba.setMeno("Jozo Mrkvicka");
        
        Zmluva zml = new Zmluva();
        zml.setCislo(cisloZmluvy);
        zml.setDruh(DruhPoisteniaEnum.ZIVOTNE);
        zml.setPoistnaSuma(33.50f);
        
        zml.getPoistenci().add(osoba);
        zml.setMajitel(osoba);
        return zml;
    }
    
}
