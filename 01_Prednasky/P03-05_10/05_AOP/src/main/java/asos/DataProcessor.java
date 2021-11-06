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

    public boolean processData() {

        if (source == null) {
            System.out.println("No datasource!");
            return false;
        }

        String data = source.getData();
        System.out.println(data);

        return data != null;

    }
    
}

