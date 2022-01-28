package IOC;

import beans.autowire_stereotype_annotations.Bus;
import beans.autowire_stereotype_annotations.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_autowire_stereotype {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_stereotype_annotation/spring_autowire_stereotype_annotation.xml");
        Bus b = (Bus) context.getBean("b1");
        b.printData();

        Car c = context.getBean(Car.class);
        c.printData();

    }
}
