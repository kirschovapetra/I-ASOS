package ws;

import static asos.DruhPoisteniaEnum.ZIVOTNE;
import asos.Osoba;
import asos.Zmluva;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Poistenie")
public class Poistenie {

    @WebMethod
    public String vytvor(@WebParam(name = "navrh") Zmluva zmluva) {
        return zmluva.getCislo();
    }
    
    @WebMethod
    public Zmluva hladaj(@WebParam(name = "cislo") String cislo) {
        
        Osoba osoba = new Osoba("Bill Gates", new Date());
        Zmluva zml = new Zmluva(ZIVOTNE, 33.50f, cislo, osoba);
        zml.addPoistenec(zml.getMajitel());
        
        return zml;
    }
}
