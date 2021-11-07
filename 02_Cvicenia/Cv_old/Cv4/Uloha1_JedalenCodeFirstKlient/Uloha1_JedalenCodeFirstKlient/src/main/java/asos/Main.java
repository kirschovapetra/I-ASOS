/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.List;

/**
 *
 * @author petra
 */
public class Main {

    static ws.Jedlo wsJedloFactory(String n, String p, Double c) {

        ws.Jedlo j = new ws.Jedlo();
        j.setNazov(n);
        j.setPopis(p);
        j.setCena(c);

        return j;
    }

    static ws2.Jedlo ws2JedloFactory(String n, String p, Double c) {

        ws2.Jedlo j = new ws2.Jedlo();
        j.setNazov(n);
        j.setPopis(p);
        j.setCena(c);

        return j;
    }

    static void wstest() {

        try {
            ws.JedalenServis_Service service = new ws.JedalenServis_Service();
            ws.JedalenServis port = service.getJedalenServisPort();

            System.out.println(port.addJedlo(wsJedloFactory("a", "aa", 1.0), ws.DenEnum.PONDELOK));
            System.out.println(port.addJedlo(wsJedloFactory("b", "bb", 2.0), ws.DenEnum.UTOROK));
            System.out.println(port.addJedlo(wsJedloFactory("c", "cc", 3.0), ws.DenEnum.STREDA));
            System.out.println(port.addJedlo(wsJedloFactory("d", "dd", 4.0), ws.DenEnum.PONDELOK));
            System.out.println(port.addJedlo(wsJedloFactory("e", "ee", 5.0), ws.DenEnum.UTOROK));

            for (ws.DenEnum den : ws.DenEnum.values()) {

                ws.Menu result = port.getMenu(den);
                System.out.println("\n" + result.getDen() + ": ");
                result.getPonuka().forEach(j -> {
                    System.out.println(j.getNazov() + " " + j.getPopis() + " " + j.getCena());
                });
            }
        } catch (ws.Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void ws2test() {

        try {
            ws2.JedalenServisMap_Service service = new ws2.JedalenServisMap_Service();
            ws2.JedalenServisMap port = service.getJedalenServisMapPort();

            System.out.println(port.addJedlo(ws2JedloFactory("a", "aa", 1.0), ws2.DenEnum.PONDELOK));
            System.out.println(port.addJedlo(ws2JedloFactory("b", "bb", 2.0), ws2.DenEnum.UTOROK));
            System.out.println(port.addJedlo(ws2JedloFactory("c", "cc", 3.0), ws2.DenEnum.STREDA));
            System.out.println(port.addJedlo(ws2JedloFactory("d", "dd", 4.0), ws2.DenEnum.PONDELOK));
            System.out.println(port.addJedlo(ws2JedloFactory("e", "ee", 5.0), ws2.DenEnum.UTOROK));

            for (ws2.DenEnum den : ws2.DenEnum.values()) {

                ws2.MenuMap result = port.getMenu(den);
                System.out.println("\n" + result.getDen() + ": ");

                List<ws2.MenuMap.Ponuka.Entry> jedla = result.getPonuka().getEntry();

                for (ws2.MenuMap.Ponuka.Entry entry : jedla) {

                    System.out.println(
                            entry.getKey()
                            + " " + entry.getValue().getPopis()
                            + " " + entry.getValue().getPopis());
                }

            }
        } catch (ws2.Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
//        wstest();
        ws2test();

    }
}
