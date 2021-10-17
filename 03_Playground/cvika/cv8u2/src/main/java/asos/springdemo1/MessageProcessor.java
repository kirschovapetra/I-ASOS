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
public class MessageProcessor {
    MessageServiceIfc service;
    MessageConsumerIfc consumer;

    public MessageProcessor(){}

    public MessageProcessor(MessageServiceIfc service, MessageConsumerIfc consumer) {
        this.service = service;
        this.consumer = consumer;
    }
    
    public MessageConsumerIfc getConsumer() {
        return consumer;
    }

    public void setConsumer(MessageConsumerIfc consumer) {
        this.consumer = consumer;
    }
    

    public MessageServiceIfc getService() {
        return service;
    }

    public void setService(MessageServiceIfc service) {
        this.service = service;
    }
    
    public void processMessage(){
        
        System.out.println("--- som v processMessage");
        
        String message = service.getMessage();

        if (message == null) return;

        consumer.putMessage(message);
    }
    
    
}
