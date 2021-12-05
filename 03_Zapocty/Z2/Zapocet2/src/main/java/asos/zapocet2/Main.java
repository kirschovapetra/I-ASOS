/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.zapocet2;

import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author petra
 */
public class Main {

    public static void main(String[] args) {

        try {
            ws.LetiskoWS_Service service = new ws.LetiskoWS_Service();
            ws.LetiskoWS port = service.getLetiskoWSPort();

            java.lang.String cestujuci = "92222";
            java.util.List<ws.Let> result = port.planLetov(cestujuci);
            
            for (ws.Let l : result) {
                String destinacia = l.getDestinacia();
                if (destinacia != null && destinacia.equals("Korfu")) {
                    String kodLetu = l.getKodLetu();

                    XMLGregorianCalendar odlet = l.getTerminLetu();
          
                    if (odlet.getDay() == 12 && odlet.getMonth() == 11 && odlet.getYear() == 2021) {
                        List<String> volne = l.getVolneMiesta();
                        
                        if (volne.isEmpty()) continue;
             
                        System.out.println(port.rezervacia(cestujuci, kodLetu, "A16"));
                        // OK: Let KO-1222 miesto A16 mate rezervovane!
                    }

                }

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
