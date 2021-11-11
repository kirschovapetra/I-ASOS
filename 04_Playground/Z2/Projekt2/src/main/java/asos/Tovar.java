/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author petra
 */
public class Tovar {
    String nazov;
    double cena;
    DostupnostEnum dostupnost;
    List<String> dodavatel = new ArrayList<>();
    
    public Tovar(String nazov, double cena, DostupnostEnum dostupnost) {
        this.nazov = nazov;
        this.cena = cena;
        this.dostupnost = dostupnost;
    }

    public Tovar(){}
    
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public DostupnostEnum getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(DostupnostEnum dostupnost) {
        this.dostupnost = dostupnost;
    }

    public List<String> getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(List<String> dodavatel) {
        this.dodavatel = dodavatel;
    }

    @Override
    public String toString() {
        return "Tovar{" + "nazov=" + nazov + ", cena=" + cena + ", dostupnost=" + dostupnost + ", dodavatel=" + dodavatel + '}';
    }
    
    
    
}
