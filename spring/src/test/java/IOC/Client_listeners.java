package IOC;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_listeners {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("listeners/spring.xml");
        ctx.start();
        ctx.stop();
        ctx.close();  // when IOC container is closed
        ctx.refresh();  // it will start your IOC container once again
    }
}
