/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component("myprocessor")
public class DataProcessor {
//    @Autowired

    private DataSourceIfc source;

//    @Autowired
//    public void setSource(DataSourceIfc source) {
//        this.source = source;
//    }
    public DataProcessor() {
    }

    @Autowired(required = false)
    public DataProcessor(DataSourceIfc source) {
        this.source = source;
    }

    public boolean processData() {
        if (source != null) {
            String s = source.getData();
            System.out.println(s);
            return s != null;
        } else {
            System.out.println("No datasource!");
            return false;
        }
    }

}
