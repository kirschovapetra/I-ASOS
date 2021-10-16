package asos;

public class DataProcessor {

    private DataSourceIfc source;   

    public DataProcessor() {
    }

//    public DataProcessor(DataSourceIfc source) {
//        this.source = source;
//    }
    
    public void setSource(DataSourceIfc source) {
        this.source = source;
    }

    public boolean processData() {
        String s = source.getData();
        System.out.println(s);
        return s!=null;
    }
    
}

