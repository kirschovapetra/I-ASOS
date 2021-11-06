/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author petra
 */
public class MainApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("myConfig.xml");
        DataSourceIfc source = ctx.getBean("mySource", DataSourceIfc.class);
        
        /******** constructor based *********/
        System.out.println(new DataProcessor(source).processData()); 
        
        /******** setter-based *************/
        DataProcessor p = new DataProcessor();
        p.setSource(source);
        System.out.println(p.processData());
        
        
        
        

    }
}
