package asos;

import java.util.concurrent.ExecutionException;
import ws.Osoba;

public class Main {

    public static void sync() {
        try {
            ws.MyWebService_Service service = new ws.MyWebService_Service();
            ws.MyWebService port = service.getMyWebServicePort();

            System.out.println("\nRegistracia prebieha...");

            Osoba o = new Osoba();
            o.setMeno("Jeffrey Bezos");
            o.setVek(1500);
            port.registruj(o);

            System.out.println("Zaregistrovany");

        } catch (Exception ex) {
            System.out.println("Hupsik");
        }
    }

    public static void asyncPolling() { 
        try {
            ws.MyWebService_Service service = new ws.MyWebService_Service();
            ws.MyWebService port = service.getMyWebServicePort();
          
          
            javax.xml.ws.Response<ws.PoistneResponse> resp = port.poistneAsync("Grecko", 25);
            
            int count = 0;
            while(!resp.isDone()) {
                System.out.println("Cakam "+ count);
                Thread.sleep(1000);
                count ++;
            }
            
            System.out.println("Result = "+resp.get().getReturn());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println("Hupsik");
        }
    }
    
    
    public static void asyncCallback(){
        try { 
            ws.MyWebService_Service service = new ws.MyWebService_Service();
            ws.MyWebService port = service.getMyWebServicePort();

            javax.xml.ws.AsyncHandler<ws.PoistneResponse> asyncHandler = 
                    (javax.xml.ws.Response<ws.PoistneResponse> response) -> {
                        try {
                            System.out.println("Result = "+ response.get().getReturn());
                        } catch(InterruptedException | ExecutionException ex) {
                            System.out.println("Hupsik");
                        }
                    };
            java.util.concurrent.Future<? extends java.lang.Object> result = 
                    port.poistneAsync("Grecko", 25, asyncHandler);
            
            int count = 0;
            while (!result.isDone()) {
                System.out.println("Cakam " + count);
                Thread.sleep(1000);
                count++;
            }
        } catch (InterruptedException ex) {
            System.out.println("Hupsik");
        }
    }
    

    public static void main(String[] args) {

//        sync();
        asyncPolling();
//        asyncCallback();
    }
}
