/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.springdemo1;

import org.aspectj.lang.JoinPoint;

/**
 *
 * @author petra
 */
public class CounterAspect {
    
    private int count;
    private int sum;

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

   
    public void countBefore(){count++;}
    public void sumAfter(JoinPoint jp, String ret){sum+=ret.length();}
    
}
