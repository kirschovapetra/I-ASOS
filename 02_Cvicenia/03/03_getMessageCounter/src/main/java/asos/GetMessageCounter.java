package asos;

import org.aspectj.lang.JoinPoint;


public class GetMessageCounter {
    
    public int count = 0;
    public int sum = 0;

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

    
    
    public void addBefore(JoinPoint jp) {
        System.out.println("[addBefore] getMessage zavolana "
                + ++count + " krat");
    }
    
    public void sumAfter(JoinPoint jp, Object result) {
        sum += result.toString().length();
        System.out.println("[sumAfter] getMessage sum = " + sum);
    }
}
