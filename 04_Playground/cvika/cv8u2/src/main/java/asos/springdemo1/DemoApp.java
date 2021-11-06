/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author petra
 */
public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("beans.xml");
        MessageProcessor mp = c.getBean("processor", MessageProcessor.class);
        CounterAspect counterAsp = c.getBean("counter", CounterAspect.class);
        mp.processMessage();
        System.out.println("");
//        System.out.println(counterAsp.getCount());
        mp.processMessage();
        System.out.println("");
//        System.out.println(counterAsp.getCount());
        mp.processMessage();
        System.out.println("");
//        System.out.println(counterAsp.getCount());
        mp.processMessage();
        System.out.println("");
//        System.out.println(counterAsp.getCount());
        mp.processMessage();
        System.out.println("");
        System.out.println("\nCount: " + counterAsp.getCount());
        System.out.println("Sum: " + counterAsp.getSum());
       
    }
}
