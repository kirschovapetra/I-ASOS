/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.concurrent.ExecutionException;

/**
 *
 * @author petra
 */
public class Main {
    
    static void async(){
        
        try { // Call Web Service Operation(async. polling)
            ws.Jedalen_Service service = new ws.Jedalen_Service();
            ws.Jedalen port = service.getJedalenPort();

            javax.xml.ws.Response<ws.FindNextPrimeResponse> resp = port.findNextPrimeAsync(100L);
            int i = 0;
            while(!resp.isDone()) {
                Thread.sleep(100);
                System.out.println(i++);
            }
            System.out.println("Result = "+resp.get().getReturn());
        } catch (InterruptedException | ExecutionException ex) {}

    }
    
    public static void main(String[] args) {
        
        try { 
//            async();
            ws.Jedalen_Service service = new ws.Jedalen_Service();
            ws.Jedalen port = service.getJedalenPort();
            System.out.println(port.vytvorJedlo("a", "aa", 0));
            System.out.println(port.vytvorJedlo("b", "bb", 0));
            System.out.println(port.vytvorJedlo("c", "cc", 0));
            
            System.out.println(port.ponuka());
//            System.out.println(port.findNextPrime(10L));
        } catch (Exception ex) {System.out.println(ex.getMessage());}

    }
}
