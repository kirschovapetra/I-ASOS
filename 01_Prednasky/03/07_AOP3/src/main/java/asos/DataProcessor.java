package asos;

public class DataProcessor {

    private DataSourceIfc source;   

    public DataProcessor() {
    }

    public DataProcessor(DataSourceIfc source) {
        this.source = source;
    }
    
    public void setSource(DataSourceIfc source) {
        this.source = source;
    }

    public void processData() {
        System.out.println("processing data...");
        if (source == null) {
            System.out.println("No datasource!");
            return;
        }
        System.out.println(source.getData());
    }
    
    public void processData(int cnt) {
        System.out.println("processing data...");
        if (source == null) {
            System.out.println("No datasource!");
            return;
        }
        for (int i = 0; i < cnt; i++) 
            System.out.println(i + ": "+source.getData());
    }
}

