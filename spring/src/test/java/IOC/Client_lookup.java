package IOC;

import beans.lookup.Bus;
import beans.lookup.Car;
import beans.lookup.Truck;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_lookup {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("lookup/spring_lookup.xml");
        Car c1 = (Car) ctx.getBean("c");
        System.out.println(c1.getClass().getCanonicalName());
        System.out.println(c1.myCarEngine().getEngineName());

        Bus b1 = (Bus) ctx.getBean("b");
        System.out.println(b1.getClass().getCanonicalName());
        System.out.println(b1.myBusEngine().getEngineName());

        Truck t1 = (Truck) ctx.getBean("t");
        System.out.println(t1.getClass().getCanonicalName());
        System.out.println(t1.myTruckEngine().getEngineName());
    }
}
