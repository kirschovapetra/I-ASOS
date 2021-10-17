/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import javax.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author petra
 */
@Configuration
//@ComponentScan(basePackages = "asos.springdemo1")
public class DemoAppConfig {
    @Bean(name = "service")
    public MessageServiceIfc serviceFactory() {
        return new MessageServiceMock();
    }

    @Bean(name = "processor")
    public MessageProcessor processorFactory(@Named("service") MessageServiceIfc ms) {
        return new MessageProcessor(ms);
    }
}
