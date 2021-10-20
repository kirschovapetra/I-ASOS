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
public class MessageProcessor {
    private MessageConsumerIfc consumer;
    private MessageServiceIfc service;
    
    public MessageProcessor(){}
    
    public MessageProcessor(MessageConsumerIfc consumer, MessageServiceIfc service) {
        this.consumer = consumer;
        this.service = service;
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
        String msg = service.getMessage();
        consumer.putMessage(msg);
    }
    
    public void prank() {
        System.out.println("you got prankd");
    }
    
    
}
