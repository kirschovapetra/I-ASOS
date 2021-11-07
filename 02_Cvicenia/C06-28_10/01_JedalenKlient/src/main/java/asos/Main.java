/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.logging.Level;
import java.util.logging.Logger;
import ws.Exception_Exception;
import ws.Jedlo;

/**
 *
 * @author petra
 */
public class Main {

    static void cv2test() {
        ws.JedalenWS_Service service = new ws.JedalenWS_Service();
        ws.JedalenWS port = service.getJedalenWSPort();
        port.vytvorJedlo("a", "aaa", 1.0);
        port.vytvorJedlo("b", "bbb", 2.0);
        port.vytvorJedlo("c", "ccc", 3.0);
        port.vytvorJedlo("d", "ddd", 4.0);
        port.vytvorJedlo("e", "eee", 5.0);

        Jedlo minJedlo = null;
        double minCena = Integer.MAX_VALUE;

        try {

            for (String nazov : port.ponuka()) {
                Jedlo jedlo = port.info(nazov);
                System.out.println(jedlo.getNazov()
                        + " " + jedlo.getPopis()
                        + " " + jedlo.getCena());

                if (jedlo.getCena() < minCena) {
                    minCena = jedlo.getCena();
                    minJedlo = jedlo;
                }
            }
            String minNazov = minJedlo.getNazov();
            System.out.println("Objednava sa : " + minNazov);
            port.objednaj(minNazov);
            System.out.println("Pocet obj: " + port.pocetObjednavok());
        } catch (Exception_Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void cv3test() {

        try {

            ws.JedalenWS_Service service = new ws.JedalenWS_Service();
            ws.JedalenWS port = service.getJedalenWSPort();
            port.vytvorJedlo("b", "bbb", 1.0);
            System.out.println(port.ponuka());
//            System.out.println("Odstranujem...");
//            port.odstranJedlo("b");
//            System.out.println("Odstranene");

//            port.zmenCenu("a", 10.0);
//            port.zmenPopis("a", "dvdfd");
            System.out.println(port.info("a"));
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

//        cv2test();
        cv3test();

    }
}
