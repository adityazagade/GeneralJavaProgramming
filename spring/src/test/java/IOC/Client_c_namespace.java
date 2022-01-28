package IOC;

import beans.c_namespace.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_c_namespace {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("c_namespace/spring_c_namespace.xml");
        Car c = (Car) context.getBean("car");
        c.printCarInfo();
    }
}
