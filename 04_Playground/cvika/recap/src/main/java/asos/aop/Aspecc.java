/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author petra
 */
public class Aspecc {
    
    public int countAll = 0;
    public int sumAll = 0;

    public Aspecc() {
    }

    public int getCountAll() {
        return countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    public int getSumAll() {
        return sumAll;
    }

    public void setSumAll(int sumAll) {
        this.sumAll = sumAll;
    }
      
    
    public void logujem(JoinPoint jp){
        System.out.println("--------- " + jp.getSignature());
    }
    
    public void gmCount(JoinPoint jp) {countAll++;}
    public void gmSum(JoinPoint jp, Object ret) {sumAll+=ret.toString().length();}


    public Object sifruj(ProceedingJoinPoint jp) throws Throwable {
        Object ret = jp.proceed();
        Object newRet = "Toto je zasifrovane: " + ret.toString();
        return newRet;
    }

    public Object desifruj(ProceedingJoinPoint jp) throws Throwable {
        Object ret = jp.getArgs()[0];
        Object newRet = "Toto je desifrovane: " + ret.toString();
        return jp.proceed(new Object[]{newRet});
    }
}
