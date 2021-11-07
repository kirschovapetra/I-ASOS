package ws;

import ejb.JedloFacadeLocal;
import entities.Jedlo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(serviceName = "JedalenEJB")
public class JedalenEJB {

    @EJB
    private JedloFacadeLocal jedloEjbRef;

    @WebMethod
    public List<Jedlo> ponuka() {
        return jedloEjbRef.findAll();
    }

    @WebMethod
    @Oneway
    public void vytvorJedlo(String nazov, String popis, double cena) {

        for (Jedlo j : ponuka()) {
            if (j.getNazov().equals(nazov)) {
                return;
            }
        }

        Jedlo jedlo = new Jedlo(nazov, popis, cena);
        jedloEjbRef.create(jedlo);

    }

    @WebMethod
    public void zmenPopis(
            @WebParam(name = "nazov") String n,
            @WebParam(name = "popis") String p) throws Exception {

        Jedlo j = jedloEjbRef.find(n);

        if (j == null) {
            throw new Exception("Jedlo s nazvom " + n + " neexistuje!");
        }

        j.setPopis(p);
        jedloEjbRef.edit(j);
    }

    @WebMethod
    public void zmenCenu(
            @WebParam(name = "nazov") String n,
            @WebParam(name = "cena") double c) throws Exception {

        Jedlo j = jedloEjbRef.find(n);

        if (j == null) {
            throw new Exception("Jedlo s nazvom " + n + " neexistuje!");
        }

        j.setCena(c);
        jedloEjbRef.edit(j);
    }

    @WebMethod
    @Oneway
    public void odstranJedlo(@WebParam(name = "nazov") String n) {
        try {
            System.out.println("\n\tstart\n");
            Thread.sleep(10000L);

            Jedlo j = jedloEjbRef.find(n);
            if (j != null) {
                jedloEjbRef.remove(j);
            }
            System.out.println("\n\tfinished\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(JedalenEJB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @WebMethod
    public Jedlo info(@WebParam(name = "nazov") String n) throws Exception {
        Jedlo j = jedloEjbRef.find(n);
        if (j == null) {
            throw new Exception("Jedlo s nazvom " + n + " neexistuje!");
        }
        return j;
    }

    @WebMethod
    public int pocetJedal() {
        return jedloEjbRef.count();
    }
    
    
}
