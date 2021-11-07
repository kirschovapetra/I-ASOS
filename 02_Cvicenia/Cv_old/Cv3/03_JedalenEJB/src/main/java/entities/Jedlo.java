package entities;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class Jedlo implements Serializable {
    
    @Id
    private String nazov;
    private String popis;
    private double cena;

    public Jedlo() {
    }

    public Jedlo(String nazov, String popis, double cena) {
        this.nazov = nazov;
        this.popis = popis;
        this.cena = cena;
    }
    
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Jedlo{" + "nazov=" + nazov + ", popis=" + popis + ", cena=" + cena + '}';
    }
    
    
    
}
