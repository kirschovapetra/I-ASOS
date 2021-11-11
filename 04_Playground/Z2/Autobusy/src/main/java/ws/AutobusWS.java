/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.Spoj;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author petra
 */
@WebService(serviceName = "AutobusWS")
public class AutobusWS {

        Map<String, Spoj> spoje = new HashMap();
        
        @WebMethod
        public void pridajSpoj(
                @WebParam(name="nazov") String nazov, 
                @WebParam(name = "ciel") String ciel,
                @WebParam(name = "volneMiesta") List<String> volneMiesta) throws Exception {
            
            if (nazov == null || ciel == null || volneMiesta == null)
                throw new Exception("Zly input");
            
            Spoj spoj = new Spoj(nazov, ciel, volneMiesta);
            
            if (spoje.containsKey(nazov))
                throw new Exception("Taky spoj uz existuje");
            
            spoje.put(spoj.getNazov(),spoj);
        }
        
        @WebMethod
        public List<Spoj> cestovnyPoriadok() {
            List<Spoj> lst = new ArrayList<>();
            lst.addAll(spoje.values());
            return lst;
        }
        
        @WebMethod
        public String rezervujMiesto(@WebParam(name = "spoj") String spoj, 
                                   @WebParam(name = "miesto") String miesto) {
           
            if (spoj == null || miesto == null) return "Zly input";

            Spoj sp = spoje.get(spoj);
           
            if (sp == null)
                return "Taky spoj neexistuje";
            
            List<String> volne = sp.getVolneMiesta();
            if (!volne.contains(miesto))
                return "Miesto " + miesto + " nie je vone";
            
            try {sleep(1000L);} 
            catch (InterruptedException ex) {}
            
            volne.remove(miesto);
            return "OK. rezervovane: " + miesto + 
                   " volne:" + sp.getVolneMiesta().toString();
        }
      
}
