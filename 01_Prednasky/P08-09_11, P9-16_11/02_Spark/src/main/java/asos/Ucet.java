package asos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 * Projekt pre P10. 
 * @author igor
 */
public class Ucet implements Serializable {
    
    private String cislo;

    private double stav;
    
    public void pripocitajUrok(){
        stav = stav + stav * 0.05;
    }

    @Override
    public String toString() {
        return "Ucet{" + "cislo=" + cislo + ", stav=" + stav + '}';
    }

    public Ucet(String cislo, double stav) {
        this.cislo = cislo;
        this.stav = stav;
    }

    public Ucet() {
    }

    public double getStav() {
        return stav;
    }

    public void setStav(double stav) {
        this.stav = stav;
    }

    public String getCislo() {
        return cislo;
    }

    public void setCislo(String cislo) {
        this.cislo = cislo;
    }

}
