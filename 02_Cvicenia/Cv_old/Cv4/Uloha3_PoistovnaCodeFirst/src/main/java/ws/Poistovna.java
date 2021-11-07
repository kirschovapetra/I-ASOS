/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.Zmluva;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Poistovna")
public class Poistovna {

   
    @WebMethod
    public Zmluva navrhZmluvy(
            @WebParam(name = "navrh") Zmluva navrh) throws Exception {
        
        /*
        preverí, či návrh zmluvy od klienta má zadaného majitela aj poistenca, 
        ak niektorý údaj chýba, vyhodí metóda Exception so správou o probléme (napr. "majitel nie je zadaný!")
        ak sú zadaní, priradí zmluve jej číslo (zadať hocaký reťazec, napr. Z1234) a vráti ju naspäť klientovi.
        */
        
        if (navrh.getMajitel() == null)
            throw new Exception("Majitel nie je zadany");
        
        if (navrh.getPoistenec()== null)
            throw new Exception("Poistenec nie je zadany");
        
        navrh.setId("lalala");
        
        return navrh;
    }
}
