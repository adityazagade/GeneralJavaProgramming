import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.SpringMessageConsumer;
import spring.SpringMessageProducer;

public class Client_SpringConsumer {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring.xml");
        SpringMessageConsumer c = (SpringMessageConsumer) ctx.getBean("consumer");
        for (int i = 0; i < 10; i++) {
            System.out.println(c.receiveMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
