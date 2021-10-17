/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author petra
 */
public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext c = new AnnotationConfigApplicationContext(DemoAppConfig.class);
        MessageProcessor mp = c.getBean("processor", MessageProcessor.class);
        mp.processMessage();
    }
}
