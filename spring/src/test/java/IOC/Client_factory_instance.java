package IOC;

import beans.factory_instance.Honda;
import beans.factory_static.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_factory_instance {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("factory_instance/spring_factory_instance.xml");
        Honda c = (Honda) ctx.getBean("c");
        c.drive();
    }
}
