/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.Arrays;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

/**
 *
 * @author petra
 */
@Configuration
public class Main {

    @Bean(name = "helloBean")
    public HelloComponent helloFactory(){return new HelloComponent();}

    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        HelloComponent hc = ctx.getBean("helloBean", HelloComponent.class);

        hc.sayHello();
        
        // vypis vsetkych komponentov
        String[] fazulky = ctx.getBeanDefinitionNames();
        Arrays.sort(fazulky);
        for (String f : fazulky) {
            System.out.println(f);
        }

    }   
}
