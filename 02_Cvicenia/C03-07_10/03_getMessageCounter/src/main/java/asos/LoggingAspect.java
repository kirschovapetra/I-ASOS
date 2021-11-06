package asos;

import org.aspectj.lang.JoinPoint;


public class LoggingAspect {

    
    public void logBefore(JoinPoint jp){
        System.out.println("[logBefore] FROM: " + 
                jp.getTarget().getClass() + " METHOD: " + jp.getSignature());
    }
}
