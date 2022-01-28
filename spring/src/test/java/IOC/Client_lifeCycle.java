package IOC;

import beans.lifecycle.Test;
import beans.lifecycle.Test1;
import beans.lifecycle.Test2;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_lifeCycle {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx1 = new ClassPathXmlApplicationContext("lifeCycle/String_lifeCycle.xml");
        Test t = (Test) ctx1.getBean("t");
        t.save(1, "s1", "e1@fakeemail.com", "a1");
        t.save(2, "s2", "e2@fakeemail.com", "a2");
        ctx1.close();

        ConfigurableApplicationContext ctx2 = new ClassPathXmlApplicationContext("lifeCycle/String_lifeCycle_plainPOJO.xml");
        Test1 t1 = (Test1) ctx2.getBean("t1");
        t1.save(1, "s1", "e1@fakeemail.com", "a1");
        t1.save(2, "s2", "e2@fakeemail.com", "a2");
        ctx2.close();

        ConfigurableApplicationContext ctx3 = new ClassPathXmlApplicationContext("lifeCycle/String_lifeCycle_annotation.xml");
        Test2 t3 = (Test2) ctx3.getBean("t3");
        t3.save(1, "s1", "e1@fakeemail.com", "a1");
        t3.save(2, "s2", "e2@fakeemail.com", "a2");
        ctx3.close();
    }
}
