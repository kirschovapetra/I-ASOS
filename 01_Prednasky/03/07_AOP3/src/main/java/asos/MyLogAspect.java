package asos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;


public class MyLogAspect {
    public void beforeAdvice(JoinPoint jp){
        System.out.println("AOP before: " + jp.getSignature());
        System.out.println("\targ: " + jp.getArgs()[0]);
    }

    public void returnAdvice(JoinPoint jp, Object res) {
        System.out.println("AOP after return: " + jp.getSignature());
        System.out.println("\tresult: " + res);
    }
    public void aroundArgAdvice(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("AOP around: " + jp.getSignature());
        System.out.println("\targ: " + jp.getArgs()[0]);
    }
    public Object aroundClockAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("AOP around clock: " + jp.getSignature());
        
        StopWatch clock = new StopWatch("Profiling");
        
        try {
            clock.start(jp.toShortString());
            return jp.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.shortSummary());
        }
    }
}
