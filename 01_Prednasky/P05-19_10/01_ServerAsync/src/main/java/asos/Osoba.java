package asos;

public class Osoba {

    private String meno;
    private int vek;

    public Osoba(String meno, int vek) {
        this.meno = meno;
        this.vek = vek;
    }

    public Osoba() {
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    @Override
    public String toString() {
        return "Osoba{" + "meno=" + meno + ", vek=" + vek + '}';
    }

}
