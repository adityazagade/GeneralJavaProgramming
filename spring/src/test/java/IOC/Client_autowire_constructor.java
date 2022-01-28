package IOC;

import beans.autowiring_xml.Bus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_autowire_constructor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_xml/spring_consturctor.xml");
        Bus c1 = (Bus) context.getBean("b1");
        c1.printData();
    }
}
