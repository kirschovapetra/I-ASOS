/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

/**
 *
 * @author petra
 */
public class Main {
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            ws.FirstService_Service service = new ws.FirstService_Service();
            ws.FirstService port = service.getFirstServicePort();
            // TODO initialize WS operation arguments here
            java.lang.String name = "aaaaa";
            // TODO process result here
            java.lang.String result = port.hello(name);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
    
}
