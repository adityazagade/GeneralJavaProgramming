package IOC;

import beans.Test_privateCons;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client_demo_privateConstructor {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring_demo_private_cons.xml");
//        // spring is able to call private constructors as well.
//        Test_privateCons t1 = (Test_privateCons) context.getBean("t1");
//        t1.hello();

        // We can also call private constructors using the reflection classes
        try {
            Class c = Class.forName("beans.Test_privateCons");
            Constructor[] cons = c.getDeclaredConstructors();
            cons[0].setAccessible(true);
            Test_privateCons t1 = (Test_privateCons) cons[0].newInstance(null);
            t1.hello();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
