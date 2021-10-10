package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("myConfig.xml");

        DataProcessorCon p1 = ctx.getBean("myProcessorCon", DataProcessorCon.class);
        DataProcessorSet p2 = ctx.getBean("myProcessorSet", DataProcessorSet.class);

        while (p1.processData() | p2.processData()) {}
        

    }
}
