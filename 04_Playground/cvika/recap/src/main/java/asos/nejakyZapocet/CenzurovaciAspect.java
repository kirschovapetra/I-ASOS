/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.nejakyZapocet;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author petra
 */
public class CenzurovaciAspect {
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public Object cenzura(ProceedingJoinPoint jp) throws Throwable{
        Object[] og = jp.getArgs();
        Object[] a = {"cenzurovane"};
        return jp.proceed(og[0]=="Greta"? a : og);
    }
    
    public void pocitaj(JoinPoint jp){
        
        System.out.println("---" + jp.getSignature());
        count++;
    }
    
}
