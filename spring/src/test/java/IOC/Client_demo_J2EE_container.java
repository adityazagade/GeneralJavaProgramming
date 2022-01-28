package IOC;

import beans.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_J2EE_container {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_demo.xml");
        Test t = (Test) ctx.getBean("t");
        t.hello();
    }
}
