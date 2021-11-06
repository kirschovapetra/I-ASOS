package asos;

import java.util.ArrayList;
import java.util.List;

public class Zmluva {
    private DruhPoisteniaEnum druh;
    private float poistnaSuma;
    private String cislo;
    private List<Osoba> poistenci = new ArrayList<>();
    private Osoba majitel;

    public Zmluva(DruhPoisteniaEnum druh, float poistnaSuma, String cislo, Osoba majitel) {
        this.druh = druh;
        this.poistnaSuma = poistnaSuma;
        this.cislo = cislo;
        this.majitel = majitel;
    }
    
    
    public void addPoistenec(Osoba osoba){
        this.poistenci.add(osoba);
    }
    
    
    public DruhPoisteniaEnum getDruh() {
        return druh;
    }

    public void setDruh(DruhPoisteniaEnum druh) {
        this.druh = druh;
    }

    public float getPoistnaSuma() {
        return poistnaSuma;
    }

    public void setPoistnaSuma(float poistnaSuma) {
        this.poistnaSuma = poistnaSuma;
    }

    public String getCislo() {
        return cislo;
    }

    public void setCislo(String cislo) {
        this.cislo = cislo;
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
    
    
}
