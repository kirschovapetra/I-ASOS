/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author petra
 */
public class Spoj {
    String nazov;
    List<String> volneMiesta = new ArrayList<>();
    String ciel;

    public Spoj(){
    }
    
    public Spoj(String nazov, String ciel, List<String> volneMiesta) {
        this.nazov = nazov;
        this.ciel = ciel;
        this.volneMiesta = volneMiesta;
    }
    
    
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public List<String> getVolneMiesta() {
        return volneMiesta;
    }

    public void setVolneMiesta(List<String> volneMiesta) {
        this.volneMiesta = volneMiesta;
    }

    public String getCiel() {
        return ciel;
    }

    public void setCiel(String ciel) {
        this.ciel = ciel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nazov);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Spoj other = (Spoj) obj;
        if (!Objects.equals(this.nazov, other.nazov)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
