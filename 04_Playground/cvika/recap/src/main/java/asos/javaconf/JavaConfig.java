/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.javaconf;

import asos.MessageServiceIfc;
import javax.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author petra
 */
@Configuration
public class JavaConfig {
    @Bean(name="SeverusSnape")
    public MessageServiceIfc tovarenNaFazulky(){
        return new JavaMessageService1();
    }
    @Bean(name="fazulka2")
    public JavaMessageProcessorSet tovarenNaFazulkySoSetterom(
            @Named("SeverusSnape") MessageServiceIfc s) {
        
        JavaMessageProcessorSet p = new JavaMessageProcessorSet();
        p.setMs(s);
        
        return p;
    }
    @Bean(name = "fazulka3")
    public JavaMessageProcessor tovarenNaFazulkySKonstruktorom(
            @Named("SeverusSnape") MessageServiceIfc s) {
        return new JavaMessageProcessor(s);
    }
}
