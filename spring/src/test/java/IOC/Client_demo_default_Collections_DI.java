package IOC;

import beans.ArrayDI.Cars;
import beans.CollectionsDI.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_default_Collections_DI {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_default_collections_di.xml");
        Object o = ctx.getBean("test");
        Test t = (Test) o;
        t.printTestData();
    }
}
