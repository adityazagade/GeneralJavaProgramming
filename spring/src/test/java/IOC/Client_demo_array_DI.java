package IOC;

import beans.ArrayDI.Cars;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_array_DI {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_array_di.xml");
        Cars cars = (Cars) ctx.getBean("cars");
        cars.printCarData();
    }
}
