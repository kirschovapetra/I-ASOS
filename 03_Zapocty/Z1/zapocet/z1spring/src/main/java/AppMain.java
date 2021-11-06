import asos.AspectBean;
import asos.Generator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

        Generator mg = context.getBean(Generator.class);
        mg.run();
        
        AspectBean ab = context.getBean(AspectBean.class);
        
        System.out.println(ab.getCount());
    }
}
