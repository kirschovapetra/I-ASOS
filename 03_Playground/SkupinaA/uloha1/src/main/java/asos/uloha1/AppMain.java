/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.uloha1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author petra
 */
public class AppMain {
    public static void main(String[] args) {
        System.out.println("\n**********************************************");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Processor p = ctx.getBean("processor", Processor.class);

        while (p.processMessage()) {
            System.out.println("\t---Pocet volani: " + AspectBean.count);
//            return;
        }
        
        
    }
}
