package asos;

import java.util.Date;


public class Osoba {
    private String meno;
    private Date datumNar;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Date getDatumNar() {
        return datumNar;
    }

    public void setDatumNar(Date datumNar) {
        this.datumNar = datumNar;
    }

    public Osoba(String meno, Date datumNar) {
        this.meno = meno;
        this.datumNar = datumNar;
    }

    public Osoba(){}
}
