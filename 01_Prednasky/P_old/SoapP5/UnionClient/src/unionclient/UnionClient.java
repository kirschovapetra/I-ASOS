/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionclient;

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
public class UnionClient {

    /**
     * @param args the command line arguments
     */
    public static void main1(String[] args) {

        Navrh z = hladaj(null);
        if (z instanceof Zmluva) {
            System.out.println("Zmluva");
            System.out.println("" + ((Zmluva) z).getCislo());
            System.out.println("" + ((Zmluva) z).getUzavreta().toString());
        } else {
            System.out.println("Navrh");
        }
        System.out.println("" + ((Osoba) z.getVlastnik()).getMeno());
        System.out.println("" + ((Osoba) z.getPoistenec().get(0).getValue()).getMeno());
        System.out.println("" + (z.getVlastnik() == z.getPoistenec().get(0).getValue()));
    }

    public static void main(String[] args) {
        Navrh navrh = new Navrh();
        navrh.setTyp(TypPoistenia.PZP);
        Osoba v = new Osoba();
        Adresa a = new Adresa();
        a.setMesto("Dolany");
        a.setUlica("Horna");
        a.setPsc("wwwww");
        v.setBydlisko(a);
        v.setMeno("Helmut Kalerab");
        v.setOid("hk-id");
        navrh.setVlastnik(v);
        navrh.getUcastnik().add(v);
        ObjectFactory f = new ObjectFactory();
        navrh.getPoistenec().add(f.createNavrhPoistenec(v));

        Zmluva z = vytvor(navrh);
        System.out.println("" + z.getCislo());
        System.out.println("" + z.getUzavreta());
    }

    private static Navrh hladaj(java.lang.String cislo) {
        sk.stuba.iko.unionwsdl.UnionWSDLService service = new sk.stuba.iko.unionwsdl.UnionWSDLService();
        sk.stuba.iko.unionwsdl.UnionWSDLPortType port = service.getUnionWSDLPort();
        return port.hladaj(cislo);
    }

    private static Zmluva vytvor(sk.stupa.iko.unionschema.Navrh navrh) {
        sk.stuba.iko.unionwsdl.UnionWSDLService service = new sk.stuba.iko.unionwsdl.UnionWSDLService();
        sk.stuba.iko.unionwsdl.UnionWSDLPortType port = service.getUnionWSDLPort();
        return port.vytvor(navrh);
    }

}
