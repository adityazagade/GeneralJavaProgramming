import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import primaryKeyGenerators.Student;

public class Client_primaryKeyGenerators_increment {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("primaryKeyGenerators/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s1 = sf.openSession();
        Transaction t = s1.beginTransaction();
        Student s = new Student();
        s.setRank(2);
        s.setSemail("gavin@king.com");
        s.setSname("gavin");
        s.setSmarks(25);

        Student s2 = new Student();
        s2.setRank(31);
        s2.setSemail("gavinasd@king.com");
        s2.setSname("gavinasd");
        s2.setSmarks(65);

        s1.persist(s2);
        s1.persist(s);
        t.commit();
        s1.close();
        sf.close();
    }
}
