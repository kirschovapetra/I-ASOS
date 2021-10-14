package asos;

import org.aspectj.lang.JoinPoint;


public class LoggingAspect {

    public void logBefore(JoinPoint jp){
        System.out.println("[LOGGUJEM BEFORE] " + jp.getSignature());
    }
}
