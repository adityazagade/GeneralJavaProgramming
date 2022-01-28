package IOC;

import beans.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client_demo_CoreContainer {
    public static void main(String[] args) {
        // Core Container
        Resource r = new ClassPathResource("spring_demo.xml");
        BeanFactory bf = new XmlBeanFactory(r);

        // create a student Object
        // Core Container will create the object on demand. Lazy loading, when getBean is called.
        // J2EE container will create the object eagerly. While loading itself it will create.
        Test s1 = (Test) bf.getBean("t");
        Test s2 = (Test) bf.getBean("t");
        Test s3 = (Test) bf.getBean("t");
        s1.hello();
        // scope="prototype" set in xml file. Then below two lines will print false.
        // scope = singleton vs prototype
        // For WebApplication we will see three more scopes : request, session, context
        System.out.println(s1==s2);
        System.out.println(s3==s2);


        // Using J2EE Container
        // eager container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_demo.xml");
        Test s11 = (Test) context.getBean("t");
        Test s22 = (Test) context.getBean("t");
        System.out.println(s11==s22);
    }
}
