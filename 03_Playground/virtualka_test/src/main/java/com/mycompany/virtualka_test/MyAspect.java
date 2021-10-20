/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualka_test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 *
 * @author edu
 */
public class MyAspect {
    
    private int count = 0;
    private int sum = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    
    
    public void before(JoinPoint jp){
        System.out.println("--- BEFORE: " + jp.getSignature());
    }
    
    public void after(JoinPoint jp) {
        System.out.println("--- AFTER: " + jp.getSignature());
    }
    
    public void countBefore(JoinPoint jp) {
        System.out.println("--- COUNT getMessage BEFORE: " + jp.getSignature());
        count++;
    }
    
    public void sumAfter(JoinPoint jp, Object ret) {
        System.out.println("--- SUM getMessage AFTER RETURNING: " + jp.getSignature());
        sum += ret.toString().length();
    }
    
    public Object encryptAround(ProceedingJoinPoint jp) throws Throwable {
        Object ret = jp.proceed();
        return "Zasifrovana sprava " + ret.toString();
    }
    
    public Object decryptAround(ProceedingJoinPoint jp) throws Throwable {
        Object[] ret = jp.getArgs();
        return jp.proceed(new Object[]{"Desifrovana sprava " + ret[0].toString()});
    }
    
    public Object merajCasAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("\n[AROUND] spustam hodinky pre getMessage");
        StopWatch clock = new StopWatch("getMessage stats");
        try {
            clock.start(jp.toShortString());
            Object ret = jp.proceed();
            System.out.println(ret);
            return "haw yee";
//            return jp.proceed(new Object[]{"haw yee"});
        }
        finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
