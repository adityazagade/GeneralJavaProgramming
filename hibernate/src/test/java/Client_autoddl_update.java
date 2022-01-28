import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client_autoddl_update {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("autoddl_update/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        System.out.println("Update tables successful");
        sf.close();
    }
}