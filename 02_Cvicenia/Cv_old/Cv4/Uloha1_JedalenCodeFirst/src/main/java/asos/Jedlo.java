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
public class Jedlo {
    String nazov;
    Double cena;
    String popis;

    public Jedlo(){}
    
    public Jedlo(String nazov, Double cena, String popis) {
        this.nazov = nazov;
        this.cena = cena;
        this.popis = popis;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
    
    
    
}
