package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("myConfig.xml");
        
        /******** constructor based *********/
        System.out.println("******** constructor based ********");
        DataProcessorCon p1 = ctx.getBean("myProcessorCon", DataProcessorCon.class);
        p1.processData();

    }
}
