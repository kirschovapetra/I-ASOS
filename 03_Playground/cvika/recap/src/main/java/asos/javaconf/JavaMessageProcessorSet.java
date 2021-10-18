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

public class JavaMessageProcessorSet {
    
    MessageServiceIfc ms;

    public JavaMessageProcessorSet(MessageServiceIfc ms) {
        this.ms = ms;
    }

    public JavaMessageProcessorSet(){}
    
    public MessageServiceIfc getMs() {
        return ms;
    }

    public void setMs(MessageServiceIfc ms) {
        this.ms = ms;
    }
    
    
    public void robNeco(){
   
        System.out.println(ms.getMessage() + " hihi");
    
    }
    
}
