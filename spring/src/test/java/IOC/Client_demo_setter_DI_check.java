package IOC;

import beans.setterDI.Student;
import beans.setterDIchecking.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_setter_DI_check {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_di_setter_di_checking.xml");
        Car car = (Car) ctx.getBean("car");
    }
}
