/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author petra
 */
@Named("processor")
public class MessageProcessor {
    MessageServiceIfc service;

    public MessageProcessor(){}

    public MessageProcessor(MessageServiceIfc service) {
        this.service = service;
    }

    public MessageServiceIfc getService() {
        return service;
    }

    public void setService(MessageServiceIfc service) {
        this.service = service;
    }
    
    public void processMessage(){
        String message = service.getMessage();
        System.out.println(message);
    }
    
    
}
