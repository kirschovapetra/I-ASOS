package asos;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Response;
import ws.FindNextPrimeResponse;
import ws.Prime;
import ws.Prime_Service;


public class Main {

    static void sync(Long num) {
        long start = System.currentTimeMillis();
        Prime_Service service = new Prime_Service();
        Prime port = service.getPrimePort();

        java.lang.Long result = port.findNextPrime(num);
        System.out.println("\nResult = " + result);
        System.out.println("\nElapsed: " + (System.currentTimeMillis() - start) + " ms");
    }

    static void ayncPolling(Long num) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Prime_Service service = new Prime_Service();
        Prime port = service.getPrimePort();

        Response<FindNextPrimeResponse> resp
                = port.findNextPrimeAsync(num);
        int count = 0;
        while (!resp.isDone()) {
            System.out.println("... " + count);
            Thread.sleep(100);
            count++;
        }
        System.out.println("\nResult = " + resp.get().getReturn());
        System.out.println("\nElapsed: " + (System.currentTimeMillis() - start) + " ms");

    }

    static void ayncCallback(Long num) throws InterruptedException {
        long start = System.currentTimeMillis();
        Prime_Service service = new Prime_Service();
        Prime port = service.getPrimePort();

        javax.xml.ws.AsyncHandler<ws.FindNextPrimeResponse> asyncHandler
                = (javax.xml.ws.Response<ws.FindNextPrimeResponse> response) -> {
            try {
                System.out.println("\nResult = " + response.get().getReturn());
                System.out.println("\nElapsed: " + (System.currentTimeMillis() - start) + " ms");
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                };
        java.util.concurrent.Future<? extends Object> result
                = port.findNextPrimeAsync(num, asyncHandler);
        
        int count = 0;
        while (!result.isDone()) {
            System.out.println("... " + count);
            Thread.sleep(100);
            count++;
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        sync(100000000L);
        ayncPolling(1000000000L);
        ayncCallback(1000000000L);
    }
}
