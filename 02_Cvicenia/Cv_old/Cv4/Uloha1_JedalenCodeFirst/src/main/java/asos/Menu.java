package asos;
import java.util.*;

/*
<xs:complexType name="menu">
    <xs:sequence>
        <xs:element name="den" type="tns:denEnum" minOccurs="0"/>
        <xs:element name="ponuka" type="tns:jedlo" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
    </xs:sequence>
</xs:complexType>
 */


public class Menu {
    DenEnum den;
    List<Jedlo> ponuka = new ArrayList<>();


    public Menu(DenEnum den) {
        this.den = den;
    }

    public Menu(){}
    
    public DenEnum getDen() {
        return den;
    }

    public void setDen(DenEnum den) {
        this.den = den;
    }

    public List<Jedlo> getPonuka() {
        return ponuka;
    }

    public void setPonuka(List<Jedlo> ponuka) {
        this.ponuka = ponuka;
    }
    
    
}
