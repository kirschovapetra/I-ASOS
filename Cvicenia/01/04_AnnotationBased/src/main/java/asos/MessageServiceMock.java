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
public class MessageServiceMock implements MessageServiceIfc {
    @Override
    public String getMessage() {
        return "\nHello darkness my old friend\n";
    }
}
