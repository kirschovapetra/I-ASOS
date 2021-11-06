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
        
        GetMessageCounter counter = context.getBean("counterAspectBean", GetMessageCounter.class);
        System.out.println("\nPocet volani: " + counter.getCount());
        System.out.println("Celkova sum: " + counter.getSum());
        
        System.out.println("");
    }
}
