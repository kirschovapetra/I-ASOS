package asos;

import tmp.DataProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myConfig.xml");
        MyOperationBean bean = (MyOperationBean) context.getBean("opBean");
        System.out.println("calling m...");
        bean.m();
        System.out.println("calling k...");
        bean.k();
        System.out.println("calling msg...");
        bean.msg("hello");
    }
}
