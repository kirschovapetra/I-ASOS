package asos;

import org.springframework.stereotype.Component;

@Component("mySourceCon")
public class DataSourceCon implements DataSourceIfc {

    @Override
    public String getData() {
        return "Hello from DataSourceCon";
    }
    
}
