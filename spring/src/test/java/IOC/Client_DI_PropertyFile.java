package IOC;

import beans.propertyFileDI.DAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_DI_PropertyFile {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("PropertyFileDI/spring.xml");
        DAO t = (DAO) ctx.getBean("t");
        t.createConnection();
    }
}