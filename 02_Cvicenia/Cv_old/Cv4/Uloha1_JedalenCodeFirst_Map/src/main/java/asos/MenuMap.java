package asos;
import java.util.*;


/*
<xs:complexType name="menuMap">
    <xs:sequence>
        <xs:element name="den" type="tns:denEnum" minOccurs="0"/>
        <xs:element name="ponuka">
            <xs:complexType>
                <xs:sequence>
                    <xs:element name="entry" minOccurs="0" maxOccurs="unbounded">
                        <xs:complexType>
                            <xs:sequence>
                                <xs:element name="key" minOccurs="0" type="xs:string"/>
                                <xs:element name="value" minOccurs="0" type="tns:jedlo"/>
                            </xs:sequence>
                        </xs:complexType>
                    </xs:element>
                </xs:sequence>
            </xs:complexType>
        </xs:element>
    </xs:sequence>
</xs:complexType>
 */

public class MenuMap {
    DenEnum den;
    Map<String, Jedlo> ponuka = new HashMap<>();

    
    public MenuMap(DenEnum den) {
        this.den = den;
    }

    public MenuMap(){}
    
    public DenEnum getDen() {
        return den;
    }

    public void setDen(DenEnum den) {
        this.den = den;
    }

    public Map<String,Jedlo> getPonuka() {
        return ponuka;
    }

    public void setPonuka(Map<String,Jedlo> ponuka) {
        this.ponuka = ponuka;
    }
    
    
}
