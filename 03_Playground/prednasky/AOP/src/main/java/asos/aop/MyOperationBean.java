/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petra
 */
public class MyOperationBean {

    public void msg(String message) {
        System.out.println("msg method invoked: " + message);
        try { Thread.sleep(1500);} 
        catch (InterruptedException ex) {
            Logger.getLogger(MyOperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int m() {
        System.out.println("m method invoked");
        return 2;
    }

    public int k() {
        System.out.println("k method invoked");
        return 3;
    }
}
