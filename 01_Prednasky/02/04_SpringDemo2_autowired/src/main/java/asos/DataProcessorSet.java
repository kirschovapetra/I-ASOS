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

    DataSourceIfc sourceSet;  

    public DataProcessorSet(){}
    
    public DataProcessorSet(DataSourceIfc source) {this.sourceSet = source;}    

    public DataSourceIfc getSourceSet() {
        return sourceSet;
    }

    public void setSourceSet(DataSourceIfc sourceSet) {
        this.sourceSet = sourceSet;
    }
    
    
    
    public boolean processData() {
        String s = sourceSet.getData();
        System.out.println(s);
        return s != null;
    }
    
    
}
