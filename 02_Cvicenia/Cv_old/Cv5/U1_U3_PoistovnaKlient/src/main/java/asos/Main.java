/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.List;
import java.util.Map;
import ws.Exception_Exception;
import ws.Zmluva;
import ws.Zmluva.Ucastnici.Entry;

/**
 *
 * @author petra
 */
public class Main {
    
    static ws.Osoba osobaFactory(String id, String meno, String priezvisko){
        ws.Osoba os = new ws.Osoba();
        os.setMeno(meno);
        os.setId(id);
        os.setPriezvisko(priezvisko);
        
        return os;
    
    }
    
    public static void main(String[] args) {
        
        try { 
            ws.Poistovna_Service service = new ws.Poistovna_Service();
            ws.Poistovna port = service.getPoistovnaPort();

            ws.Osoba os1 = osobaFactory("FM", "Ferko", "Mrkvicka");
            ws.Osoba os2 = osobaFactory("MF", "Merko", "Frkvicka"); 
            
            // pridať nového poistenca do zmluvy s neexistujúcim čislom (servis by mal vyhodiť výnimku a klient by ju mal odchytiť)
//            ws.Osoba os3 = osobaFactory("JF", "Janko", "Fazulka");
//            port.pridajPoistenca("123456", os3);
            
            // vytvorí novú zmluvu s jediným účastníkom, ktorý je zároveň poistencom aj majitelom
            ws.Zmluva navrh = new Zmluva();
            navrh.setMajitel(os1);
            navrh.getPoistenci().add(os1);
            // následne do novej zmluvy pridá dalšieho poistenca
            String c = port.novaZmluva(navrh);
            System.out.println(c);
            System.out.println(port.pridajPoistenca(c, os2));
            
            // a nakoniec vyhľadá novú zmluvu a vypíše mená učastníkov, majiteľa aj poistených osôb.
            ws.Zmluva zml = port.najdiZmluvu(c);
            ws.Osoba maj = zml.getMajitel();
            List<ws.Osoba> poi = zml.getPoistenci();
            List<Entry> uc = zml.getUcastnici().getEntry();
            
            System.out.println("MAJITEL: " + maj.getId() + " " + maj.getMeno() + " " + maj.getPriezvisko());
            
            System.out.println("\nPOISTENCI:");
            poi.forEach(p -> {
                System.out.println(p.getId() + " " + p.getMeno() + " " + p.getPriezvisko());
            });
            
            System.out.println("\nUCASTNICI:");
            uc.stream().map(entry -> entry.getValue()).forEachOrdered(p -> {
                System.out.println(p.getId() + " " + p.getMeno() + " " + p.getPriezvisko());
            });
            
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
