package IOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_dependsOn {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dependsOn/spring_dependsOn.xml");
    }
}
