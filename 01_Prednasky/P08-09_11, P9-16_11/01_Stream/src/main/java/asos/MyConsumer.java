/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.function.Consumer;

/**
 *
 * @author petra
 */
public class MyConsumer implements Consumer<Ucet>{

    @Override
    public void accept(Ucet t) {
        t.pripocitajUrok(0.5);
        System.out.println(t);
    }
    
    
    
}
