package asos;

import java.util.Date;

/**
 *
 * @author petra
 */
public class Osoba {

    public enum Gen {
        MUZ, ZENA
    };

    private String meno;
    private Date narodena;
    private Gen gen;
    private Adresa bydlisko;

    public Osoba(String meno, Date narodena, Gen gen, Adresa bydlisko) {
        this.meno = meno;
        this.narodena = narodena;
        this.gen = gen;
        this.bydlisko = bydlisko;
    }

        
    public Osoba(String meno, Date narodena, Gen gen) {
        this.meno = meno;
        this.narodena = narodena;
        this.gen = gen;
    }
    
    public Osoba(String meno, Gen gen, Adresa bydlisko) {
        this.meno = meno;
        this.gen = gen;
        this.bydlisko = bydlisko;
        this.narodena = new Date();
    }

    
    public Osoba(){}

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Date getNarodena() {
        return narodena;
    }

    public void setNarodena(Date narodena) {
        this.narodena = narodena;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public Adresa getBydlisko() {
        return bydlisko;
    }

    public void setBydlisko(Adresa bydlisko) {
        this.bydlisko = bydlisko;
    }

    @Override
    public String toString() {
        return "Osoba{" + "meno=" + meno + ", narodena=" + narodena + ", gen=" + gen + ", bydlisko=" + bydlisko + '}';
    }
    
    

}
