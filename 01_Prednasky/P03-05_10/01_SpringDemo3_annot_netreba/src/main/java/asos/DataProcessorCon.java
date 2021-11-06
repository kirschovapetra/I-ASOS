package asos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myProcessorCon")
public class DataProcessorCon {

    DataSourceIfc source;  

    public DataProcessorCon(){}
    
    @Autowired
    public DataProcessorCon(DataSourceIfc source) {this.source = source;}    

    public DataSourceIfc getSource() {
        return source;
    }

    public void setSource(DataSourceIfc source) {
        this.source = source;
    }
    
    
    
    public boolean processData() {
        String s = source.getData();
        System.out.println(s);
        return s != null;
    }
    
    
}
