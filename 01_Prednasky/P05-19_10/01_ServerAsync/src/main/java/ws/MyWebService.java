package ws;

import asos.Osoba;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "MyWebService")
public class MyWebService {

    @WebMethod(operationName = "bish")
    public String serus(@WebParam(name = "niecoSemNapis") String txt) {
        return "Test raz dva " + txt + " !";
    }

    @WebMethod(operationName = "poistne")
    public double pocitajPoistne(String krajina, int pocetDni) {
        if (pocetDni <= 0) {
            throw new IllegalArgumentException("Pocet dni musi byt > 0");
        }

        System.out.println("Vypocet poistneho trva dlho");

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Posielam odpoved");

        return 0.5 * pocetDni;
    }

    @WebMethod
    @Oneway // iba pre void ktore nehadzu vynimky
    public void registruj(Osoba osoba) {

        System.out.println("\n\tRegistrujem osobu: " + osoba);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n\tHotovo");

    }
}
