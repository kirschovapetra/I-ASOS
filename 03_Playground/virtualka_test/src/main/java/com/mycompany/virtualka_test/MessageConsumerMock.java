/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualka_test;

/**
 *
 * @author edu
 */
public class MessageConsumerMock implements MessageConsumerIfc {

    @Override
    public void putMessage(String msg) {
        System.out.println(msg);
    }
    
    
}
