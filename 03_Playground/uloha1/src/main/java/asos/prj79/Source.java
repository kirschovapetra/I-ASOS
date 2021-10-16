/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.prj79;

/**
 *
 * @author osboxes
 */
public class Source implements ISource{
    private int counter = 0;
    
    @Override
    public String getMessage() {
        if(counter == 0){
            counter++;
            return "Juraj Vrabec";
        }else {
            return "nie je moje meno";
        }
    }
    
}
