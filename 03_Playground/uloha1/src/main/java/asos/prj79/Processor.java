/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.prj79;

/**
 *
 * @author igor
 */
public class Processor implements IProcessor{
    private ISource source;

    public Processor(ISource source) {
        this.source = source;
    }
    
    
    @Override
    public void processMessages() {
        for (int i=0; i<3; i++) {
            String m = source.getMessage();
            System.out.println("Sprava " + i + ": " + m);
        }        
    }
}

