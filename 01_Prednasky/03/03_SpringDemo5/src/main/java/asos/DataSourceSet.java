package asos;

public class DataSourceSet implements DataSourceIfc {
       
    int count = 5;

    public int getCount() {return count;}

    public void setCount(int count) {this.count = count;}

    @Override
    public String getData() {
        return (count > 0) ? "Hello from DataSourceSet " + count-- : null;
    }
}
