package IOC;

import beans.CollectionsDI.Test1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_Collections_DI {
    public static void main(String[] args) {
        // Core container does not support xsd. You will have to go through J2EE container only
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_collections_di.xml");
        Object o = ctx.getBean("test");
        Test1 t = (Test1) o;
        t.printTestData();
    }
}
