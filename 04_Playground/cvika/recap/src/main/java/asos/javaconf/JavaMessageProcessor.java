/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.javaconf;

import asos.MessageServiceIfc;
import javax.inject.Named;

/**
 *
 * @author petra
 */

public class JavaMessageProcessor {
    
    MessageServiceIfc ms;

    public JavaMessageProcessor(MessageServiceIfc ms) {
        this.ms = ms;
    }

    public JavaMessageProcessor(){}
    
    public MessageServiceIfc getMs() {
        return ms;
    }

    public void setMs(MessageServiceIfc ms) {
        this.ms = ms;
    }
    
    
    public void robNeco(){
   
        System.out.println(ms.getMessage() + " haha");
    
    }
    
}
