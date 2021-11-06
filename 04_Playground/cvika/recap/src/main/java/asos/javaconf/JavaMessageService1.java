/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.javaconf;

import asos.MessageServiceIfc;
import javax.inject.Named;

/**
 *
 * @author petra
 */
public class JavaMessageService1 implements MessageServiceIfc{

    @Override
    public String getMessage() {
        return "mam prilis vela kofeinu v krvi";
    }
    
}
