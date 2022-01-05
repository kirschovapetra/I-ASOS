package asos;

import java.util.function.Supplier;


public class MySupplier2 implements Supplier<Integer>{
    
    static int i = 0;
    
    @Override
    public Integer get(){
//        System.out.println(i);
        return i++;
       
    }
}
