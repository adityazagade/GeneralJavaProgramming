package IOC;

import beans.p_namespace.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_p_namespace {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("p_namespace/spring_p_namespace.xml");
        Car c = (Car) context.getBean("car");
        c.printCarInfo();
    }
}
