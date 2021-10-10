/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poistovnaclient;

import org.netbeans.xml.schema.poistovna.Adresa;
import org.netbeans.xml.schema.poistovna.NavrhZmluvy;
import org.netbeans.xml.schema.poistovna.DruhPoistenia;
import org.netbeans.xml.schema.poistovna.Osoba;
import org.netbeans.xml.schema.poistovna.PoistnaZmluva;

/**
 *
 * @author vsa
 */
public class PoistovnaClient {

    /**
     * @param args the command line arguments
     */
    public static int trtkoCount = 1;
    
    public static Osoba zrobTrtka() {
        Osoba ret = new Osoba();
        
        Adresa plejs = new Adresa();
        plejs.setObec("Vystne ruzbachy");
        plejs.setUlica("Pri kanale " + (trtkoCount * 1.25));
        
        ret.setId(""+trtkoCount);
        ret.setMeno("Turbotrt " + trtkoCount);
        ret.setRodneCislo("123456");
        ret.setBydlisko(plejs);
        
        trtkoCount++;
        
        return ret;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        NavrhZmluvy draft = new NavrhZmluvy();
        
        //Osoba ucastnik_1 = ;
        
        draft.setDruh(DruhPoistenia.ZIVOTNE);
        
        for(int i= 0; i < 5; i++) {
            Osoba trtko = zrobTrtka();
            draft.getUcastnikZmluvy().add(trtko);
            draft.getPoistenaOsoba().add(trtko);
        }
        
        draft.getPoistnik().add((Object) draft.getUcastnikZmluvy().get(0));
        
        PoistnaZmluva ret = podatNavrh(draft);
        
        Osoba poistnik = (Osoba) ret.getPoistnik().get(0);
        System.out.print("Tento kokotko to poistil: "+ poistnik.getId());
    }

    private static PoistnaZmluva podatNavrh(org.netbeans.xml.schema.poistovna.NavrhZmluvy navrh) {
        org.netbeans.j2ee.wsdl.postiovnaschema.schema.podatnavrh.PodatNavrhService service = new org.netbeans.j2ee.wsdl.postiovnaschema.schema.podatnavrh.PodatNavrhService();
        org.netbeans.j2ee.wsdl.postiovnaschema.schema.podatnavrh.PodatNavrhPortType port = service.getPodatNavrhPort();
        return port.podatNavrh(navrh);
    }
    
    
    
}
