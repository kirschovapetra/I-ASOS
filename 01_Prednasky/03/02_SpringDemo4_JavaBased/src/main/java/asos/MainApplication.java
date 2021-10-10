package asos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        /******** constructor based *********/
        System.out.println("******** constructor based ********");
        DataProcessorCon p1 = ctx.getBean("myProcessorCon", DataProcessorCon.class);
        p1.processData();
        
        /******** setter-based *************/
        System.out.println("******** setter-based *************");
        DataProcessorSet p2 = ctx.getBean("myProcessorSet", DataProcessorSet.class);
        p2.processData();
    }
}
