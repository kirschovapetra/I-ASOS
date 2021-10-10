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
public class DataSource implements DataSourceIfc {
    @Override
    public String getData() {
        return "\nHello from DataSource\n";
    }
}
