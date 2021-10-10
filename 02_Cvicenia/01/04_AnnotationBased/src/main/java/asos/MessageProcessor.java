/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

/**
 *
 * @author petra
 */
@Service("processor")
public class MessageProcessor {
    @Autowired
    @Qualifier("mock")
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
