/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import asos.aop.Aspecc;
import asos.aop.Aspecc;
import asos.aop.MessageProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author petra
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("fazulky_1.xml");
        MessageProcessor mp = context.getBean("processor", MessageProcessor.class);
        mp.robNeco();
        mp.robNeco();
//        mp.robNeco();
//        mp.robNeco();
//        mp.robNeco();
//        mp.robNeco();
        
        Aspecc asp = context.getBean(Aspecc.class);
        System.out.println("count: " + asp.getCountAll() + " sum: " + asp.getSumAll());
    }
}
