/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import ws.DumbBitchException_Exception;

/**
 *
 * @author petra
 */
public class Main {
    public static void main(String[] args) {
        
        try { 
            ws.Projekt2Service_Service service = new ws.Projekt2Service_Service();
            ws.Projekt2Service port = service.getProjekt2ServicePort();
 
            System.out.println(port.pridajTovar("a", 1, ws.DostupnostEnum.NASKLADE));
            System.out.println(port.pridajTovar("b", 2, ws.DostupnostEnum.NEDOSTUPNE));
            System.out.println(port.pridajTovar("c", 3, ws.DostupnostEnum.NASKLADE));
            
            System.out.println(port.pridajDodavatela("a", "Alza"));
            System.out.println(port.pridajDodavatela("a", "Mall.sk"));
            System.out.println(port.pridajDodavatela("b", "idk.sk"));
            
            ws.Tovar t = port.hladajTovar("a");
            System.out.println(t.getNazov() + 
                    " " + t.getCena() + 
                    " " + t.getDostupnost() + 
                    " " + t.getDostupnost());
                
            t = port.hladajTovar("b");
            System.out.println(t.getNazov()
                    + " " + t.getCena()
                    + " " + t.getDostupnost()
                    + " " + t.getDostupnost());
            
            t = port.hladajTovar("c");
            System.out.println(t.getNazov()
                    + " " + t.getCena()
                    + " " + t.getDostupnost()
                    + " " + t.getDostupnost());
            
        } catch (DumbBitchException_Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
