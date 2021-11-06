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
public class DataProcessorSet {

    DataSourceIfc source;  

    public DataProcessorSet(){}
    
    public DataProcessorSet(DataSourceIfc source) {this.source = source;}    

    public DataSourceIfc getSource() {
        return source;
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
