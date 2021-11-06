/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 *
 * @author petra
 */
public class MyAspectBean {
    
    public void myBeforeAdvice(JoinPoint jp){
        System.out.println("[LOGGING BEFORE] " + jp.getSignature());
    }
    public void myReturnAdvice(JoinPoint jp, Object result){
        System.out.println("[LOGGING AFTER RETURN] " + jp.getSignature() 
                + " ret: " + result);
    }
    public Object myAroundAdvice(ProceedingJoinPoint jp, String message) throws Throwable {
        System.out.println("[LOGGING AROUND] " + message);
        StopWatch clock = new StopWatch("\tProfiling");
        try {
            clock.start(jp.toShortString());
            return jp.proceed(/*new Object[]{"nove args"}*/);
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
    
}
