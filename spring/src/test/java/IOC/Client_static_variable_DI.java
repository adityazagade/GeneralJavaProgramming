package IOC;

import beans.static_variablesDI.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_static_variable_DI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("static_variablesDI/spring_static_variables.xml");
        Car c = (Car) context.getBean("c1");
        c.printCar();
    }
}
