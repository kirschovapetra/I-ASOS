package asos;

import org.aspectj.lang.JoinPoint;


public class MyLogAspect {
    public void loggingAdviceBefore(JoinPoint jp){
        
        System.out.println("AOP before: " + jp.getSignature());
    }
    public void loggingAdviceAfter(JoinPoint jp) {
        System.out.println("AOP after: " + jp.getSignature());
    }
}
