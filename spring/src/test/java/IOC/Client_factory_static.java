package IOC;

import beans.factory_static.Car;
import beans.singleton.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_factory_static {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("factory_static/spring_factory_static");
        Car c = (Car) ctx.getBean("c");
        c.drive();

    }
}
