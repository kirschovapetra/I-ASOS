package asos;

import org.aspectj.lang.JoinPoint;


public class GetMessageCounter {
    
    public static int count = 0;
    public static int sum = 0;

    public void addBefore(JoinPoint jp) {
        System.out.println("[addBefore] getMessage zavolana "
                + ++count + " krat");
    }
    
    public void sumAfter(JoinPoint jp, Object result) {
        sum += result.toString().length();
        System.out.println("[sumAfter] getMessage sum = " + sum);
    }
}
