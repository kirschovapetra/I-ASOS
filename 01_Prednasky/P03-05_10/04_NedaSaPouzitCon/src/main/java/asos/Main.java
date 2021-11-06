package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("myConfig.xml");
        Subject subj = ctx.getBean("mySubject", Subject.class);
        Observer obs = ctx.getBean("myObserver", Observer.class);
        
        subj.setState("novy stav");
        subj.setState("halo");
        
        
    }
}
