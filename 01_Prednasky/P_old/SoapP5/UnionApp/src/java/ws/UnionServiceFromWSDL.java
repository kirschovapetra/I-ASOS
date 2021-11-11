/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import sk.stupa.iko.unionschema.Adresa;
import sk.stupa.iko.unionschema.Navrh;
import sk.stupa.iko.unionschema.ObjectFactory;
import sk.stupa.iko.unionschema.Osoba;
import sk.stupa.iko.unionschema.TypPoistenia;
import sk.stupa.iko.unionschema.Zmluva;

/**
 *
 * @author vsa
 */
@WebService(serviceName = "UnionWSDLService", portName = "UnionWSDLPort", endpointInterface = "sk.stuba.iko.unionwsdl.UnionWSDLPortType", targetNamespace = "http://iko.stuba.sk/UnionWSDL", wsdlLocation = "WEB-INF/wsdl/UnionServiceFromWSDL/UnionWSDL.wsdl")
public class UnionServiceFromWSDL {

    Navrh vzor;
    Map<String, Zmluva> zmluvy;

    private void initVzor() {
        Adresa a = new Adresa();
        a.setMesto("Dolany");
        a.setUlica("Horna");
        a.setPsc("12345");

        Osoba jm = new Osoba();
        jm.setBydlisko(a);
        jm.setMeno("Jozko Mrkvicka");
        jm.setOid("jm-id");

        Osoba am = new Osoba();
        am.setBydlisko(a);
        am.setMeno("Adela Mrkvickova");
        am.setOid("am-id");

        vzor = new Navrh();
        vzor.setTyp(TypPoistenia.PZP);
        vzor.getUcastnik().add(jm);
        vzor.getUcastnik().add(am);
        vzor.setVlastnik(jm);

        ObjectFactory f = new ObjectFactory();
        vzor.getPoistenec().add(f.createNavrhPoistenec(jm));
        vzor.getPoistenec().add(f.createNavrhPoistenec(am));

    }

    public UnionServiceFromWSDL() {
        initVzor();
        zmluvy = new HashMap<>();
    }


    public sk.stupa.iko.unionschema.Navrh hladaj(java.lang.String cislo) {
        // Vyhladame zmluvu podla cisla
        Zmluva z = zmluvy.get(cislo);
        if (z == null) {
            // ak sa nenasla vratime vzor - Navrh
            return vzor;
        }
        return z;
    }

    public sk.stupa.iko.unionschema.Zmluva vytvor(sk.stupa.iko.unionschema.Navrh navrh) {
        XMLGregorianCalendar now = null;
        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new Date());
            now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(UnionServiceFromWSDL.class.getName()).log(Level.SEVERE, null, ex);
        }

        Zmluva z = new Zmluva();
        z.setCislo("z" + zmluvy.size());
        z.setUzavreta(now);
        z.setPoistne(99.99f);
        
        // ostatne skopirujeme z navrhu
        z.setTyp(navrh.getTyp());
        z.getUcastnik().addAll(navrh.getUcastnik());
        z.setVlastnik(navrh.getVlastnik());
        z.getPoistenec().addAll(navrh.getPoistenec());

        zmluvy.put(z.getCislo(), z);
        return z;
    }
    
}
