package IOC;

import beans.singleton.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class Client_singleton {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("singleton/spring_singleton.xml");
        Test t1 = (Test) ctx.getBean("t");
        Test t2 = (Test) ctx.getBean("t");
        System.out.println(t1 == t2);

        Calendar c1 = (Calendar) ctx.getBean("c");
        Calendar c2 = (Calendar) ctx.getBean("c");
        Calendar cal = Calendar.getInstance();
        System.out.println(cal == c1);  // returns false
        System.out.println(c2 == c1);   // returns true
    }
}
