package asos;

public class DataProcessorCon {

    DataSourceIfc source;  

    public DataProcessorCon(){}
    
    public DataProcessorCon(DataSourceIfc source) {this.source = source;}    

    public DataSourceIfc getSource() {
        return source;
    }

    public void setSource(DataSourceIfc source) {
        this.source = source;
    }
    
 
    public boolean processData() {

        if (source == null){
            System.out.println("No datasource!");
            return false;
        }
        
        String data = source.getData();
        System.out.println(data);
        
        return data != null;
         
    }
     
}
