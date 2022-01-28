package IOC;

import beans.autowiring_xml.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_autowire_byType {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_xml/spring_byType.xml");
        Car c1 = (Car) context.getBean("c1");
        c1.printData();
    }
}
