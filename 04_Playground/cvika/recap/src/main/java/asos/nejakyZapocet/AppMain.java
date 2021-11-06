/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.nejakyZapocet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author petra
 */
public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("fazulky_zapocet.xml");
        Processor mp = context.getBean("processor", Processor.class);
        
        while (mp.processMessage()){}
        
        CenzurovaciAspect c = context.getBean(CenzurovaciAspect.class);
        System.out.println(c.count);
        
    }
    
}
