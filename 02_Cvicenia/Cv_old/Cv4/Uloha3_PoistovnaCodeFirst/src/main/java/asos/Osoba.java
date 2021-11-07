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
    String meno;
    String priezvisko;
    Date datumNar;

    public Osoba(){}
    
    public Osoba(String meno, String priezvisko, Date datumNar) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datumNar = datumNar;
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

    public Date getDatumNar() {
        return datumNar;
    }

    public void setDatumNar(Date datumNar) {
        this.datumNar = datumNar;
    }
    
    
}
