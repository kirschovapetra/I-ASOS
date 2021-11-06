/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.nejakyZapocet;

/**
 *
 * @author petra
 */
public class Processor {
    Source s;
    Consumer c;

    public Processor(Source s, Consumer c) {
        this.s = s;
        this.c = c;
    }

    public Source getS() {
        return s;
    }

    public void setS(Source s) {
        this.s = s;
    }

    public Consumer getC() {
        return c;
    }

    public void setC(Consumer c) {
        this.c = c;
    }
    
    public boolean processMessage(){
        String msg = s.getMessage();
        
        if (msg == null) return false;
        
        c.putMessage(msg);
        return true;
    }
    
}
