package asos;


public class Adresa {
    private String obec;
    private String ulica;
    private String psc;

    public Adresa(String obec, String ulica, String psc) {
        this.obec = obec;
        this.ulica = ulica;
        this.psc = psc;
    }
    
    public Adresa(String obec) {
        this.obec = obec;
    }

    
    public Adresa(){}
    
    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    @Override
    public String toString() {
        return "Adresa{" + "obec=" + obec + ", ulica=" + ulica + ", psc=" + psc + '}';
    }
    
    
    
    
}
