/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.Osoba;
import asos.Zmluva;
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author petra
 */
@WebService(serviceName = "Poistovna")
@Stateless
public class Poistovna {

    Map<String, Zmluva> zmluvy = new HashMap<>();

    @WebMethod
    public Zmluva najdiZmluvu(@WebParam(name = "cislo") String cislo) throws Exception {

        if (cislo == null) {
            throw new Exception("nepis mi sem sprostosti");
        }

        if (!zmluvy.containsKey(cislo)) {
            throw new Exception("taku zmluvu nemam bruh");
        }

        return zmluvy.get(cislo);
    }

    @WebMethod
    public String novaZmluva(@WebParam(name = "navrhZmluvy") Zmluva navrh) throws Exception {
        /*
        skontroluje, či zmluva má majitela a aspoň jedného poistenca, 
        ak nie vráti výnimku
        priradí zmluve jednoznačné číslo, dátum uzavretia, 
        zaradí ju do zoznamu uzavretých zmlúv a vráti jej číslo
        
         */
        
        Osoba majitel = navrh.getMajitel();
        List<Osoba> poistenci = navrh.getPoistenci();
        
        if (majitel == null || poistenci.isEmpty()) {
            throw new Exception("ffjnjfn");
        }

    
        String cislo = "" + System.currentTimeMillis();
        navrh.setCislo(cislo);
        navrh.setUzavreta(new Date());
        
        
        List<Osoba> ucastnici = new ArrayList<>();
        ucastnici.add(majitel);
        ucastnici.addAll(poistenci);
               
        navrh.addUcastnici(ucastnici);
        zmluvy.put(cislo, navrh);
        
        return cislo;
        
    }

    @WebMethod
    public String pridajPoistenca(@WebParam(name = "cisloZmluvy")String cislo, 
            @WebParam(name = "poistenec") Osoba poistenec) throws Exception {
        /*
        vyhľadá uzavretú zmluvu podľa čísla a pridá do nej poistenca.
ak zmluva z neexistuje vráti výnimku.
         */
        
        Zmluva zml = najdiZmluvu(cislo);
        List<Osoba> poistenci = zml.getPoistenci();
        
        if (poistenec.getId() == null)
            throw new Exception("idcko");
        
        for (Osoba p: poistenci) {
            if (p.getId() == null 
                ? poistenec.getId() == null 
                : p.getId().equals(poistenec.getId())) return "Failure";
        }
        
        poistenci.add(poistenec);
        List<Osoba> pList = new ArrayList<>();
        pList.add(poistenec);
        zml.addUcastnici(pList);
        
        return "Success";
    }

}
