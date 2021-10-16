/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class DataSourceMock implements DataSourceIfc{

    public String getData() {
        return null;
    }
}
