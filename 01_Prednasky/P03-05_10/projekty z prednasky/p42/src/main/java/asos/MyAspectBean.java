/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 *
 * @author igor
 */
public class MyAspectBean {

    public void beforeAdvice(JoinPoint jp) {
        System.out.println("AOP before: " + jp.getSignature());
        System.out.println("\targ: " + jp.getArgs()[0]);
    }

    /* vypise navratovu hodnotu  */
    public void myReturnAdvice(JoinPoint jp, Object result) {
        System.out.println("AOP after return");
        System.out.println("\tresult: " + result);
    }

    /* zmeni hodnotu argumentu volanej metody */
    public Object myAroundArgAdvice(ProceedingJoinPoint call) throws Throwable {
        System.out.println("AOP around: " + call.getSignature());
        System.out.println("      Args: " + call.getArgs()[0]);
        Object[] par = {5};
        return call.proceed(par);
    }

    /* zmeni navratovu hodnotu na retazec "nic"*/
    public Object myAroundRetAdvice(ProceedingJoinPoint call) throws Throwable {
        System.out.println("AOP around: " + call.getSignature());
        Object r = call.proceed(); 
        System.out.println("  returned: " + r);
        return "nic";
    }
    
    /* zisti a vypise dobu vykonavania volanej metody */
    public Object myAroundClockAdvice(ProceedingJoinPoint call) throws Throwable {
        System.out.println("AOP around: " + call.getSignature());
        StopWatch clock = new StopWatch("Profiling");
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.shortSummary());
        }
    }

}
