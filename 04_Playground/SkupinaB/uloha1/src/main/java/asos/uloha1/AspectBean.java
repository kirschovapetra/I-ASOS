/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.uloha1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author petra
 */
public class AspectBean {
    
    public static int count = 0;
    
    public void countVoidMethods(JoinPoint jp) {
//        System.out.println("[LOG AFTER] " + jp.getSignature());
        count++;
    }
    
    public Object censor(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("[LOG AROUND] " + jp.getSignature());
        Object[] args = jp.getArgs();

        String input = args[0] == null ? "" : args[0].toString();
        
        if (!input.contains("Greta")) return jp.proceed();

        return jp.proceed(new Object[]{"cenzurovane"});
    }
}
