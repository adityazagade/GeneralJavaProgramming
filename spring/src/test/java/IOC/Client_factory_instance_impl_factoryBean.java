package IOC;

import beans.factory_instance.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_factory_instance_impl_factoryBean {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("factory_instance/spring_factory_withFactoryBean_instance.xml");
        Car c = (Car) ctx.getBean("cf");
        c.drive();
    }
}
