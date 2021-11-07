package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "Prime")
public class Prime {

    @WebMethod
    public Long findNextPrime(Long num) {
        
        long start = System.currentTimeMillis();
        
        num++;
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                num++;
                i = 2;
            }
        }
        
        long finish = System.currentTimeMillis();
        System.out.println("\nElapsed: " + (finish-start) + " ms");
       
        return num;
    }
}
