package asos;

import ws.Exception_Exception;

public class Main {

    
    public static void main(String[] args) {
        try {

            ws.JedalenEJB_Service service = new ws.JedalenEJB_Service();
            ws.JedalenEJB port = service.getJedalenEJBPort();
            port.vytvorJedlo("a", "aaa", 2.0);
            port.vytvorJedlo("b", "bbb", 1.0);

            port.ponuka().forEach(j -> {
                System.out.println(j.getNazov()
                        + " " + j.getPopis()
                        + " " + j.getCena());
            });

//            System.out.println("Odstranujem...");
//            port.odstranJedlo("b");
//            System.out.println("Odstranene");
//            port.zmenCenu("a", 10.0);
            port.zmenPopis("c", "dvdfd");
//            System.out.println(port.info("a"));
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
