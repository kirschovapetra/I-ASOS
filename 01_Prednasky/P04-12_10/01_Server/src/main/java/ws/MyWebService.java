package ws;

import asos.Osoba;
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
        if (pocetDni <= 0)  
            throw new IllegalArgumentException("Pocet dni musi byt > 0");
        
        return 0.5 * pocetDni;
    }
    
    @WebMethod()
    public void registruj(Osoba osoba) throws InterruptedException {
        
        
        
        System.out.println("\n\tRegistrujem osobu: " + osoba);
        
        Thread.sleep(5000);
        
        System.out.println("\n\tHotovo");
        
    }
}
