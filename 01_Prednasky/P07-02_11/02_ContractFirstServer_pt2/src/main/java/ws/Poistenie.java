/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;

/**
 *
 * @author petra
 */
@WebService(serviceName = "PoistenieFromWSDL", portName = "PoistenieFromWSDLPort", endpointInterface = "ws.PoistenieFromWSDL", targetNamespace = "http://ws/", wsdlLocation = "WEB-INF/wsdl/PoistenieFromWSDLpt2.wsdl")
public class Poistenie {

    public static Osoba initOsoba(String id, String meno, ws.Adresa adresa) {
        Osoba o = new Osoba();
        o.setId("jm001");
        o.setMeno("Jozko Mrkvicka");
        o.setDatumNar(null);
        o.setBydlisko(adresa);
        return o;
    }

    public static Zmluva initZmluva(String cisloZmluvy, DruhPoisteniaEnum druh, float suma) {

        Zmluva zml = new Zmluva();
        zml.setCislo(cisloZmluvy);
        zml.setDruh(druh);
        zml.setPoistnaSuma(suma);

        return zml;
    }

    public static Adresa initAdresa(String ulica, String psc) {

        Adresa adr = new Adresa();
        adr.setUlica(ulica);
        adr.setPsc(psc);

        return adr;
    }

    public ws.Zmluva hladaj(java.lang.String cisloZmluvy) {

        Adresa adresa = initAdresa("Horna Dolna", "12345");

        Osoba o1 = initOsoba("jm001", "Jozko Mrkvicka", adresa);
        Osoba o2 = initOsoba("jm002", "Anka Mrkvicka", adresa);
        Zmluva zmluva = initZmluva(cisloZmluvy, DruhPoisteniaEnum.PZP, 123.4f);

        zmluva.setMajitel(o1);

        zmluva.getPoistenci().add(o1);
        zmluva.getPoistenci().add(o2);

        zmluva.getUcastnici().add(o1);
        zmluva.getUcastnici().add(o2);

        return zmluva;

    }

    public java.lang.String vytvor(ws.Zmluva zmluva) {
        
        String c = zmluva.getCislo();
        zmluva.setCislo("noveCislo_" + c);
        return zmluva.getCislo();
    }

}
