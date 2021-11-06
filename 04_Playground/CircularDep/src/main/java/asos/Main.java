package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ServiceB b = context.getBean(ServiceB.class);
        
        System.out.println(b.getCombinedSecrets());
    }
}
