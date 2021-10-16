/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import javax.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "asos")
public class AppConfig {

    @Bean(name="mysource")
    public DataSourceIfc msFactory() {
        return new DataSourceMock();
    }
    
    @Bean(name="myprocessor")
    public DataProcessor mpFactory(@Named("mysource") DataSourceIfc source) {
        DataProcessor dp = new DataProcessor();
        dp.setSource(source);
        return dp;
    }
}
