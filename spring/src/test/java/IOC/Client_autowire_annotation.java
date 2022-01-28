package IOC;

import beans.autowire_annotation.Bus;
import beans.autowire_annotation.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_autowire_annotation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_annotation/spring_annotation.xml");
        Bus b  = (Bus) context.getBean("b1");
        Car c  = (Car) context.getBean("c1");
        b.printData();
        c.printData();
    }
}
