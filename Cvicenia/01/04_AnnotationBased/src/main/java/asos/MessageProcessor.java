/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author petra
 */
public class MessageProcessor {
    private MessageServiceIfc messageService;
    
    public MessageProcessor(){}
    
    public MessageProcessor(MessageServiceIfc messageService) {
        this.messageService = messageService;
    }

    @Required
    public void setMessageService(MessageServiceIfc messageService) {
        this.messageService = messageService;
    }
    
    
    public void processMessage() {
        System.out.println(messageService.getMessage());
    }
}
