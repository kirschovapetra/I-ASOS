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
public class Ucet {
    
    private String cislo;
    private double stav;
    public Ucet(){}
    public Ucet(String cislo, double stav) {
        this.cislo = cislo;
        this.stav = stav;
    }

    public String getCislo() {
        return cislo;
    }

    public void setCislo(String cislo) {
        this.cislo = cislo;
    }

    public double getStav() {
        return stav;
    }

    public void setStav(double stav) {
        this.stav = stav;
    }
    
    public void pripocitajUrok(double u){
        stav += stav * u;
    }

    @Override
    public String toString() {
        return "Ucet{" + "cislo=" + cislo + ", stav=" + stav + '}';
    }
    
    
    
}
