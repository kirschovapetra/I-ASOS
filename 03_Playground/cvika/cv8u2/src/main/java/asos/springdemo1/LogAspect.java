/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import org.aspectj.lang.JoinPoint;

/**
 *
 * @author petra
 */
public class LogAspect {

    public void logBefore(JoinPoint jp){
        System.out.println("\n--------------------------------------------------");
        System.out.println("[logBefore] " + jp.toLongString());
        System.out.println("[logBefore] " + jp.toShortString());
        System.out.println("[logBefore] " + jp.getSignature());
        System.out.println("[logBefore] " + jp.getSourceLocation());
        System.out.println("[logBefore] " + jp.getTarget());
        System.out.println("[logBefore] " + jp.getThis());
        System.out.println("--------------------------------------------------\n");
    }   
}
