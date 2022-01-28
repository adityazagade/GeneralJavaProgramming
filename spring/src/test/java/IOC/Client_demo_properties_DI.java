package IOC;

import beans.ArrayDI.Cars;
import beans.PropertiesDI.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_properties_DI {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_properties_di.xml");
        Test t = (Test) ctx.getBean("test");
        t.printDrivers();
    }
}
