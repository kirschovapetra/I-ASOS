package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        MessageProcessor mp = context.getBean("processor", MessageProcessor.class);
        mp.processMessage();
    }
}
