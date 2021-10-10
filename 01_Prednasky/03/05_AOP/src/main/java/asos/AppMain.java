package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("myConfig.xml");
        
        DataProcessor processor =  context.getBean("myprocessor", DataProcessor.class);

        boolean cont=true;
        while(cont) {
            cont = processor.processData();
        }
        System.out.println("hotovo");
   }  
}
