package asos;

public class DataSourceMock implements DataSourceIfc{
    @Override
    public String getData() {
        return "dummy";
    }
}
