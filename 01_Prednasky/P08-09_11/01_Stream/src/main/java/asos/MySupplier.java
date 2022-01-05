package asos;

import java.util.function.Supplier;


public class MySupplier implements Supplier<Ucet>{

    int count = 0;
    int maxPocet = 10;
    
    @Override
    public Ucet get() {
        count++;
        
        if (count > maxPocet) {
            return null;
        
        }
        
        return new Ucet("U"+count, count*100);
    }
    
}
