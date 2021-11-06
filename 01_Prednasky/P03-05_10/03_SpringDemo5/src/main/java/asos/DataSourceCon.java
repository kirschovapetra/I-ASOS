package asos;

public class DataSourceCon implements DataSourceIfc {
    private int count = 5;

    @Override
    public String getData() { 
        return (count > 0) ? "Hello from DataSourceCon " + count-- : null;
    }
    
}
