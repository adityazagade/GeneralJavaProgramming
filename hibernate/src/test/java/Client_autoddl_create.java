import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client_autoddl_create {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("autoddl_create/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        System.out.println("Create tables successful");
        sf.close();
    }
}
