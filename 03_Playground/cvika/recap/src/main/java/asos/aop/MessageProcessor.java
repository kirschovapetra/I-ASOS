/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.aop;

import asos.MessageServiceIfc;

/**
 *
 * @author petra
 */
public class MessageProcessor {
    
    MessageServiceIfc ms;
    MessageConsumerIfc mc;
    

    public MessageProcessor(MessageServiceIfc ms, MessageConsumerIfc mc) {
        this.ms = ms;
        this.mc = mc;
    }

    public MessageProcessor(){}

    public MessageConsumerIfc getMc() {
        return mc;
    }

    public void setMc(MessageConsumerIfc mc) {
        this.mc = mc;
    }


    
    public MessageServiceIfc getMs() {
        return ms;
    }

    public void setMs(MessageServiceIfc ms) {
        this.ms = ms;
    }
    
    
    public void robNeco(){
   
        String msg = ms.getMessage();
        mc.putMessage(msg);
    }
    
}
