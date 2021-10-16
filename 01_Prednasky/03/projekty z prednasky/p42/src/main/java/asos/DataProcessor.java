/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author igor
 */
public class DataProcessor {

    private DataSourceIfc ds;

    public DataProcessor() {
    }

    // ctor-based DI
//    public DataProcessor(DataSourceIfc ds) {
//        this.ds = ds;
//    }
    // setter-based DI
    public void setDs(DataSourceIfc ds) {
        this.ds = ds;
    }

    public void processData() {
        System.out.println("processing data...");
        if (ds != null) {
            System.out.println(ds.getStringData());
        } else {
            System.out.println("No datasource!");
        }

    }

    public void processData(int cnt) {
        System.out.println("processing data...");
        if (ds != null) {
            for (int i = 0; i < cnt; i++) {
                System.out.println("" + i + ": " + ds.getStringData());
            }
        } else {
            System.out.println("No datasource!");
        }

    }

}
