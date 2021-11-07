package ws;

import asos.Jedlo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "JedalenWS")
@Stateless() // uchovava si svoj stav, generuje sa iba 1 trieda
public class JedalenWS {

    private Map<String, Jedlo> ponuka = new HashMap<>();
    private List<Jedlo> objednavky = new ArrayList<>();

    @WebMethod
    public String[] ponuka() {

        return ponuka.keySet().toArray(new String[0]);
    }

    @WebMethod
    public void vytvorJedlo(String nazov, String popis, double cena) {
        if (!ponuka.containsKey(nazov)) {
            ponuka.put(nazov, new Jedlo(nazov, popis, cena));
        }
    }

    @WebMethod
    @Oneway // vo wsdl nebude odstranJedloResponse
    public void odstranJedlo(@WebParam(name = "nazov") String n) {
        
        try {
            System.out.println("\n\tstart\n");
            Thread.sleep(10000L);
            if (ponuka.containsKey(n)) {
                ponuka.remove(n);
            }
            System.out.println("\n\tfinished\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(JedalenWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @WebMethod
    public Jedlo info(@WebParam(name = "nazov") String n) throws Exception {
        
        if (!ponuka.keySet().contains(n))
            throw new Exception("Jedlo s nazvom " + n + " neexistuje!");
        
        return ponuka.get(n);
    }

    @WebMethod
    public void zmenCenu(
            @WebParam(name = "nazov") String n, 
            @WebParam(name = "cena") double c) 
            throws Exception {
        
        // vo wsdl: 
        // <fault message="tns:Exception" name="Exception" 
        // wsam:Action="http://ws/JedalenWS/zmenCenu/Fault/Exception"/>
        
        if (!ponuka.keySet().contains(n))
            throw new Exception("Jedlo s nazvom " + n + " neexistuje!");
        
        ponuka.get(n).setCena(c);
    }

    @WebMethod
    public void zmenPopis(
            @WebParam(name = "nazov") String n,
            @WebParam(name = "popis") String p) throws Exception {
        
        if (!ponuka.keySet().contains(n))
            throw new Exception("Jedlo s nazvom " + n + " neexistuje!");
        
        ponuka.get(n).setPopis(p);
    }

    @WebMethod
    public void objednaj(@WebParam(name = "nazov") String nazov) throws Exception {

        if (ponuka.keySet().contains(nazov)) {
            Jedlo jedlo = ponuka.get(nazov);
            objednavky.add(jedlo);
        }
    }
    

  
    @WebMethod
    public int pocetObjednavok() {
        return objednavky.size();
    }

    
}
