/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualka_test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edu
 */
public class MessageServiceMock implements MessageServiceIfc{

    @Override
    public String getMessage() {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MessageServiceMock.class.getName()).log(Level.SEVERE, null, ex);
//        } finally{
            return "yee haw";
//        }
    }
    
}
