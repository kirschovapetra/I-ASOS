/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;



public class Main {
    
    
    public static ws.Zmluva hladaj(String cislo){
       
        ws.Poistenie_Service service = new ws.Poistenie_Service();
        ws.Poistenie port = service.getPoisteniePort();
        return port.hladaj(cislo);
    }
    
    public static String vytvor(ws.Zmluva navrh) {

        ws.Poistenie_Service service = new ws.Poistenie_Service();
        ws.Poistenie port = service.getPoisteniePort();
        return port.vytvor(navrh);
    }

    
    public static void main(String[] args) {
        // Code First:
        // service -> wsdl -> client (wsimport)
        // neda sa vytvorit 1 objekt pre osoby - vzdy budu rozne
           
        ws.Zmluva z = hladaj("x111");
        
        ws.Osoba majitel = z.getMajitel();
        ws.Osoba poistenec = z.getPoistenci().get(0);
        
        System.out.println(z.getDruh() + " " + z.getPoistnaSuma());
        System.out.println(majitel.getMeno());
        System.out.println(poistenec.getMeno());
        System.out.println(majitel == poistenec); // false = 2 rozne osoby

    }
}
