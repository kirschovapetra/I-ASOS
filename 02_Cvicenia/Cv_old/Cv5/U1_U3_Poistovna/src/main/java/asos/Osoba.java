/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.Date;

/**
 *
 * @author petra
 */
public class Osoba {
    String id;
    String meno;
    String priezvisko;
    Date nar;
    
    public Osoba(){}
    
    public Osoba(String id){this.id=id;}
    
    public Osoba(String id, String meno, String priezvisko, Date nar) {
        this.meno = meno;
        this.id = id;
        this.priezvisko = priezvisko;
        this.nar = nar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public Date getNar() {
        return nar;
    }

    public void setNar(Date nar) {
        this.nar = nar;
    }

    
}
