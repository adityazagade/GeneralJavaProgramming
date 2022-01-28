import cache.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientSessionFactoryLevelCacheExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle_sf_level_cache.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Session session2 = sf.openSession();

        Student s1 = session.get(Student.class, 3);
        Student s2 = session2.get(Student.class, 3);

        System.out.println(s1.getSname());
        System.out.println(s2.getSname());
    }
}
