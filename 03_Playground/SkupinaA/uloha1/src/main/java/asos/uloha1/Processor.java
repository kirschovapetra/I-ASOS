/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.uloha1;

/**
 *
 * @author petra
 */
public class Processor {
    
    private Source source;
    private Consumer consumer;
    
    public Boolean processMessage(){
        String msg = source.getMessage();
        
        if (msg != null) consumer.putMessage(msg);

        return msg != null;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
    
    
    
}
