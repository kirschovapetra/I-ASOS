/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import asos.prj79.MyAspect;
import asos.prj79.IProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author igor
 */
public class AppMain {
    
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

        IProcessor mp = context.getBean(IProcessor.class);
        
        mp.processMessages();
    }
}
