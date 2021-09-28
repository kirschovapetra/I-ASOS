/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author petra
 */
public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
        
        MessageProcessor mp = context.getBean("processor", 
                                              MessageProcessor.class);
        mp.processMessage();
    }
}