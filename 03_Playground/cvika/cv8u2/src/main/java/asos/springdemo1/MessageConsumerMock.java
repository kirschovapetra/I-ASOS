/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

/**
 *
 * @author petra
 */
public class MessageConsumerMock implements MessageConsumerIfc {

    @Override
    public void putMessage(String msg) {
        System.out.println("--- som v putMessage");
        System.out.println(msg);
    }
    
}
