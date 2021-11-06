/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualka_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author edu
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        MessageProcessor mp = context.getBean("processor", MessageProcessor.class);
        mp.processMessage();
        mp.prank();
//        mp.processMessage();
//        mp.processMessage();
//        mp.processMessage();
//        mp.processMessage();
        
        System.out.println(context.getBean(MyAspect.class).getCount());
        System.out.println(context.getBean(MyAspect.class).getSum());
    }
}
