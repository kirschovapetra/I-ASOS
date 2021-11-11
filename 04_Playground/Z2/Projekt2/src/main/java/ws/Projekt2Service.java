/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.DostupnostEnum;
import asos.DumbBitchException;
import asos.Tovar;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author petra
 */
@WebService(serviceName = "Projekt2Service")
public class Projekt2Service {
 
    
    Map<String, Tovar> sklad = new HashMap<>();
    
    @WebMethod
    public Tovar hladajTovar(@WebParam(name = "nazov") String nazov) throws DumbBitchException {
        
        if (nazov == null) throw new DumbBitchException("nazov nemoze byt null");
        
        if (!sklad.containsKey(nazov)) throw new DumbBitchException("taky tovar neexistuje");
        
        return sklad.get(nazov);
    }
    
    @WebMethod
    public String pridajTovar(@WebParam(name = "nazov") String nazov,
                             @WebParam(name = "cena") double cena,
                             @WebParam(name = "dostupnost") DostupnostEnum dostupnost) throws DumbBitchException {

        if (nazov == null) {
            throw new DumbBitchException("nazov nemoze byt null");
        }

        if (sklad.containsKey(nazov)) {
            throw new DumbBitchException("taky tovar uz existuje");
        }
        
        Tovar t = new Tovar(nazov, cena, dostupnost);
        
        sklad.put(nazov, t);
        
        return t + " pridany ";
    }
    
    @WebMethod
    public String pridajDodavatela(@WebParam(name = "nazov") String nazov,
                                 @WebParam(name = "dodavatel") String dodavatel) throws DumbBitchException {

        if (nazov == null || dodavatel == null) {
            throw new DumbBitchException("nazov ani dodavatel nemoze byt null");
        }

        Tovar t = hladajTovar(nazov);
        
        if (t.getDodavatel().contains(dodavatel))
            throw new DumbBitchException("taky dodavatel uz existuje duh");
        
        t.getDodavatel().add(dodavatel);
        
        return dodavatel + " pridany do " + nazov;
    }
}
