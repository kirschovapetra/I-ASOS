package ws;

import asos.Adresa;
import asos.Osoba;
import asos.Osoba.Gen;
import static asos.Osoba.Gen.MUZ;
import static asos.Osoba.Gen.ZENA;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "WSosoby")
public class WSosoby {

    
    @WebMethod
    public Osoba info(@WebParam(name = "meno") String meno,
            @WebParam(name = "mesto") String mesto) {
        
        return new Osoba(meno, 
                meno.endsWith("a") ? ZENA : MUZ, 
                new Adresa(mesto));
    }
    
    @WebMethod
    public Osoba[] Simpsons() {
        
        Adresa adr = new Adresa("Springfield");
        
        Osoba[] simpsons = {
            new Osoba("Homer", MUZ, adr),
            new Osoba("Bart", MUZ, adr),
            new Osoba("Lisa", ZENA, adr)
        };
        
        return simpsons;
    }
}
