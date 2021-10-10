/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author petra
 */
@Configuration
@ComponentScan
public class DemoApp {
    
    @Bean("processor")
    public MessageProcessor getMp(){
        return new MessageProcessor();
    }
    
    public static void main(String[] args) {
        ApplicationContext context
        = new AnnotationConfigApplicationContext(DemoApp.class);
    
        MessageProcessor mp = context.getBean("processor", MessageProcessor.class);        
        mp.processMessage();
    }
}
