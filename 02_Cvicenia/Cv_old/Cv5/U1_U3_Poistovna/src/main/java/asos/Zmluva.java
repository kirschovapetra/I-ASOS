/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author petra
 */
public class Zmluva {
    String cislo;
    Date uzavreta;
    Druh druh;
    
    
    Map<String, Osoba> ucastnici = new HashMap<>();
    List<Osoba> poistenci = new ArrayList<>();
    Osoba majitel;
    
    public Zmluva(){}
    
    public Zmluva(Osoba majitel, List<Osoba> poistenci) {
        this.poistenci = poistenci;
        this.majitel = majitel;
    }
    
    public Zmluva(Druh druh, Osoba majitel, List<Osoba> poistenci) {
        this.druh = druh;
        this.majitel = majitel;
        this.poistenci = poistenci;
    }
    
    public Zmluva(Druh druh, Osoba majitel) {
        this.druh = druh;
        this.majitel = majitel;
    }


    public Map<String, Osoba> getUcastnici() {
        return ucastnici;
    }

    public void setUcastnici(Map<String, Osoba> ucastnici) {
        this.ucastnici = ucastnici;
    }

    public List<Osoba> getPoistenci() {
        return poistenci;
    }

    public void setPoistenci(List<Osoba> poistenci) {
        this.poistenci = poistenci;
    }

    public Osoba getMajitel() {
        return majitel;
    }

    public void setMajitel(Osoba majitel) {
        this.majitel = majitel;
    }
    
    public void addUcastnici(List<Osoba> osoby){
        
        for (Osoba o : osoby) {
            if (!ucastnici.containsKey(o.getId()))
                ucastnici.put(o.getId(), o);
        }
    }

    public String getCislo() {
        return cislo;
    }

    public void setCislo(String cislo) {
        this.cislo = cislo;
    }

    public Date getUzavreta() {
        return uzavreta;
    }

    public void setUzavreta(Date uzavreta) {
        this.uzavreta = uzavreta;
    }

    public Druh getDruh() {
        return druh;
    }

    public void setDruh(Druh druh) {
        this.druh = druh;
    }
    
    
    
}
