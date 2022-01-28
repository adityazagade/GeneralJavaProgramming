import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_temp_consumer {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring_for_listener.xml");
    }
}
