package IOC;

import beans.setterDI.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_setter_DI_passByInstance {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_di_setter_passByInstance.xml");
        Car c = (Car)ctx.getBean("car");
    }
}
