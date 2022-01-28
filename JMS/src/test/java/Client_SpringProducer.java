import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.SpringMessageProducer;

public class Client_SpringProducer {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring.xml");
        SpringMessageProducer p = (SpringMessageProducer) ctx.getBean("producer");
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            p.sendMessage("Message " + i);
            Thread.sleep(1000);
        }
    }
}
