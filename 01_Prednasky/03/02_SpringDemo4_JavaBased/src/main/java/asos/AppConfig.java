package asos;

import javax.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {
    
    @Bean(name="mySourceCon")
    public DataSourceIfc dsConFactory(){return new DataSourceCon();}

    @Bean(name = "myProcessorCon")
    public DataProcessorCon dpConFactory(@Named("mySourceCon") DataSourceIfc src){
        DataProcessorCon dp = new DataProcessorCon(src);
        return dp;
    }
    
    @Bean(name = "mySourceSet")
    public DataSourceIfc dsSetFactory() {return new DataSourceSet();}
    
    @Bean(name = "myProcessorSet")
    public DataProcessorSet dpSetFactory(@Named("mySourceSet") DataSourceIfc src) {
        DataProcessorSet dp = new DataProcessorSet();
        dp.setSource(src);
        return dp;
    }
    
}
