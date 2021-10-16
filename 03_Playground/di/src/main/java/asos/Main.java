package asos;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                
        System.out.println(context.getBeanDefinitionCount());
        
        Map<String, TranslationService> beanz = context.getBeansOfType(TranslationService.class);
        
        for (String id : beanz.keySet()){
            System.out.println(beanz.get(id).translate("to je jedno"));
        }

    }
}
