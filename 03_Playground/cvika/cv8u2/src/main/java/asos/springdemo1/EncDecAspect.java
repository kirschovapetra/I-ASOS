/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author petra
 */
public class EncDecAspect {
    
    public Object encryptAround(ProceedingJoinPoint jp) throws Throwable{
        String ret = jp.proceed().toString();
        return "Zasifrovane " + ret;
    }
    public void decryptAround(ProceedingJoinPoint jp) throws Throwable{
        Object[] args = jp.getArgs();
        jp.proceed(new Object[]{"Desifrovane "+ args[0].toString()});
    }
    
}
