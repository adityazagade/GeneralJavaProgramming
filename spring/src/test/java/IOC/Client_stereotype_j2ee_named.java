package IOC;

import beans.stereotype_j2ee_named.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_stereotype_j2ee_named {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("stereotype_j2ee_named/spring.xml");
        Car c = (Car) context.getBean(Car.class);
        c.printCar();
    }
}
