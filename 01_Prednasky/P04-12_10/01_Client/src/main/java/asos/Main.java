package asos;

import ws.InterruptedException_Exception;
import ws.Osoba;


public class Main {
    
    // WSDL: http://localhost:8080/01_Server/MyWebService?WSDL
    public static void main(String[] args) {
        
        try { 
            ws.MyWebService_Service service = new ws.MyWebService_Service();
            ws.MyWebService port = service.getMyWebServicePort();

            System.out.println("\nHello world = "+port.bish("--> abcd <--"));
            System.out.println("\nPoistne = "+port.poistne("--> abcd <--", 5));
            
            System.out.println("\nRegistracia prebieha...");
            
            Osoba o = new Osoba();
            o.setMeno("Jeffrey Bezos");
            o.setVek(1500);
            port.registruj(o);
            
            System.out.println("Zaregistrovany");
            
        } catch (InterruptedException_Exception ex) {
            System.out.println("Hupsik");
        }

        
    }
}
