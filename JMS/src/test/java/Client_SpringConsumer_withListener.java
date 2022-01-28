import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.SpringMessageConsumer;

public class Client_SpringConsumer_withListener {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring_for_listener.xml");
    }
}
