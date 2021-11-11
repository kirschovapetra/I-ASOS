
package sk.stupa.iko.unionschema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypPoistenia.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TypPoistenia"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PZP"/&gt;
 *     &lt;enumeration value="ZIVOTNE"/&gt;
 *     &lt;enumeration value="CESTOVNE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TypPoistenia")
@XmlEnum
public enum TypPoistenia {


    /**
     * PZP
     * 
     */
    PZP,

    /**
     * ZIVOTNE
     * 
     */
    ZIVOTNE,

    /**
     * cest
     * 
     */
    CESTOVNE;

    public String value() {
        return name();
    }

    public static TypPoistenia fromValue(String v) {
        return valueOf(v);
    }

}
