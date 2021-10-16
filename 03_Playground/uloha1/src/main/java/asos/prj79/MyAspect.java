package asos.prj79;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author petra
 */
public class MyAspect {
    private static int count = 0;

    
    public Object censorGetMessage(ProceedingJoinPoint jp) throws Throwable{
        Object ret = jp.proceed();
        return ret.equals("Juraj Vrabec") ? "Cenzura" : ret;
    }
   
    
    
}
