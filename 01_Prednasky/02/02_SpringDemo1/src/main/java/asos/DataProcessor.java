/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

/**
 *
 * @author petra
 */
public class DataProcessor {

    DataSourceIfc source;  

    public DataProcessor(){}
    
    public DataProcessor(DataSourceIfc source) {this.source = source;}    

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
