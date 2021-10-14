package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {

    public static void main(String[] args) {
       
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("\n-----------------------------------------------------------------");
        
        MessageProcessor mp = context.getBean("processor", MessageProcessor.class);
        mp.processMessage();
        mp.processMessage();
        mp.processMessage();
        mp.processMessage();
        mp.processMessage();
        
        System.out.println("\nPocet volani: " + GetMessageCounter.count);
        System.out.println("Celkova sum: " + GetMessageCounter.sum);
        
        System.out.println("");
    }
}
