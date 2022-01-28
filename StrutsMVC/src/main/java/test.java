import model.PlayerManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
        PlayerManager plManager = (PlayerManager) context.getBean("playerManager");
        try {
            int id = plManager.registerPlayer("Aditya", "kolad", "xyz@fakeemail.com", "male", 25);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
