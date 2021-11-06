package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("myConfig.xml");
        
        DataProcessor mp =  context.getBean("myprocessor", DataProcessor.class);
        mp.processData(3);
   }  
}
