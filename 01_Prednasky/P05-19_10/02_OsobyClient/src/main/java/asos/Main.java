/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

/**
 *
 * @author petra
 */
public class Main {

    public static void callInfo() {
        try { // Call Web Service Operation
            ws.WSosoby_Service service = new ws.WSosoby_Service();
            ws.WSosoby port = service.getWSosobyPort();
            // TODO initialize WS operation arguments here
            java.lang.String meno = "meno";
            java.lang.String mesto = "mesto";
            // TODO process result here
            ws.Osoba result = port.info(meno, mesto);
            System.out.println("Result = " + result.toString());
        } catch (Exception ex) {}
    }

    public static void callSimpsons() {

        try { // Call Web Service Operation
            ws.WSosoby_Service service = new ws.WSosoby_Service();
            ws.WSosoby port = service.getWSosobyPort();
            // TODO process result here
            java.util.List<ws.Osoba> result = port.simpsons();
            
            result.forEach(os -> {
                System.out.println(os);
            });

        } catch (Exception ex) {}
    }

    public static boolean compareAddress() {

        try {
            ws.WSosoby_Service service = new ws.WSosoby_Service();
            ws.WSosoby port = service.getWSosobyPort();

            java.util.List<ws.Osoba> result = port.simpsons();

            ws.Adresa adr1 = result.get(0).getBydlisko();
            ws.Adresa adr2 = result.get(1).getBydlisko();

            return adr1 == adr2;

        } catch (Exception ex) { return false;}
    }
    
    public static void main(String[] args) {

//        callInfo();
        callSimpsons();
        
        // adresy nie su rovnake lebo kazda je podelementom ineho objektu
        System.out.println(compareAddress());
    }
}
