package asos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    /*
    this - priama trieda ktora vola metodu (musi byt priamo vytvorenia, nie cez proxy triedu)
    target - trieda ktora vola metodu 
    execution - presny popis metody
    args - parametre ktore metoda vola
    */
    
    
//    @Pointcut("target(MessageConsumerMock)")
//    @Pointcut("this(MessageConsumerMock)") // implementuje rozhranie, cize nefunguje takto jednoducho
//    @Pointcut("execution(* asos.*.*(..))")
    @Pointcut("execution(* asos.*.*(..)) && !target(asos.MessageProcessor)")
    public void pointcut(){}
    
//    @Before(":target(asos.DemoApp)")
    @Before("pointcut()")
    public void logBefore(JoinPoint jp){
        System.out.println("[LOGGUJEM BEFORE] " + jp.getSignature());
    }
//    @After(":target(asos.DemoApp)")
    @After("pointcut()")
    public void logAfter(JoinPoint jp) {
        System.out.println("[LOGGUJEM AFTER] " + jp.getSignature());
    }
////    @Around(":target(asos.DemoApp)")
//    @Around("pointcut()")
//    public void logAround(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("[LOGGUJEM AROUND] " + jp.getSignature());
//    }
}
