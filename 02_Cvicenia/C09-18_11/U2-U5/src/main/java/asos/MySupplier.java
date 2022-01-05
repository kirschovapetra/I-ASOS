package asos;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.function.Supplier;


public class MySupplier implements Supplier<Integer>{
    boolean init = false;
    int numGenerated = 0;
    SecureRandom random;
    
    @Override
    public Integer get(){

        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException ex) {}
        
        
        if (!init) {
            random.setSeed(new Date().getTime());
            init = true;
            System.out.println("Seeding");
        }
        final int nextInt = random.nextInt();
        System.out.println("Generated random " + numGenerated++ + ": " + nextInt);
        return nextInt;
    }
}
