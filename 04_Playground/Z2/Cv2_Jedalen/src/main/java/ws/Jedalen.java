/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.Jedlo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;

/**
 *
 * @author petra
 */
@WebService(serviceName = "Jedalen")
@Stateless()
public class Jedalen {

    Map<String, Jedlo> jedla = new HashMap<>();
    List<String> objednane = new ArrayList<>();
    
    @WebMethod
    public boolean vytvorJedlo(String n, String p, double c){
       
        if (n == null || p == null || jedla.containsKey(n))
            return false;
        
        jedla.put(n, new Jedlo(n, p, c));
        return true;
    }

    @WebMethod
    @Oneway
    public void odstranJedlo(String n) {

        if (n == null || !jedla.containsKey(n)) {
             return;
        }

        try {
            Thread.sleep(5000L);
            jedla.remove(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jedalen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @WebMethod
    public Jedlo info(String n){
        if (jedla.containsKey(n))
            return jedla.get(n);
                    
        return null;
    }
    
    @WebMethod
    public List<String> ponuka() {
        List<String> ponuk = new ArrayList<>();
        ponuk.addAll(jedla.keySet());
        return ponuk;
    }
    
    @WebMethod
    public boolean zmenCenu(String nazov, double cena){
        if (nazov == null) {
            return false;
        }

        
        Jedlo j = info(nazov);
        if (j == null) return false;
        
        j.setCena(cena);
        return true;
    }

    @WebMethod
    public boolean zmenPopis(String nazov, String popis){
        if (nazov == null || popis == null) {
            return false;
        }

        Jedlo j = info(nazov);
        if (j == null) {
            return false;
        }

        j.setPopis(popis);
        return true;
    }

    @WebMethod
    public boolean objednaj(String nazov) throws Exception{
        if (nazov == null) {
            return false;
        }

        objednane.add(nazov);
        return true;
    }

    @WebMethod
    public int pocetObjednavok(String nazov){
        int count = 0;
        for (String meno : objednane){
            if (meno == null 
                    ? nazov == null 
                    : meno.equals(nazov))
                count++;
        }
        return count;
    }
    
    @WebMethod
    public Long findNextPrime(Long n){
        try {
            Thread.sleep(5000L);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Jedalen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n + 1;
    }
}
