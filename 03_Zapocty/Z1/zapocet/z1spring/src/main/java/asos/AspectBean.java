/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author petra
 */
public class AspectBean {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void countFilterPut(JoinPoint jp){
        count++;
    }
    
    public Object toUpperProcessorPut(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        String upper = args[0].toString().toUpperCase();

        return jp.proceed(new Object[]{upper});
    }
}
