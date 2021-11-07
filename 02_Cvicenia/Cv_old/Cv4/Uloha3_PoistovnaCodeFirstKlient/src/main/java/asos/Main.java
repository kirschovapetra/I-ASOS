/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import ws.Exception_Exception;

public class Main {
    public static void main(String[] args) {
        
        /*
        vytvorí Zmluvu a jednu Osobu, pričom táto osoba bude v zmluve aj majitelom aj poistencom.
        pošle zmluvu na server a v odpovedi zo servera overí, či majiteľ a poistenec stále tá istá osoba. Viete si vysvetliť prečo nie je?

        v prípade výnimky ju odchytí a vypíše správu.
        */
        
        try { 
            ws.Poistovna_Service service = new ws.Poistovna_Service();
            ws.Poistovna port = service.getPoistovnaPort();
            
            ws.Osoba osoba = new ws.Osoba();
            osoba.setMeno("Jozko");
            osoba.setPriezvisko("Mrkivicka");
            
            ws.Zmluva navrh = new ws.Zmluva();
            navrh.setMajitel(osoba);
            navrh.setPoistenec(osoba);
         
            ws.Zmluva result = port.navrhZmluvy(navrh);
            System.out.println("Result = "+result.getId() +
                    " M: " + result.getMajitel().getMeno() + 
                    " " + result.getMajitel().getPriezvisko() +
                    " P: " + result.getPoistenec().getMeno() + 
                    " " + result.getPoistenec().getPriezvisko()
            
            );
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
