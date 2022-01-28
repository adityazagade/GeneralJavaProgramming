import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import primaryKeyGenerators.Student;

public class Client_primaryKeyGenerators_assigned {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("primaryKeyGenerators/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s1 = sf.openSession();
        Transaction t = s1.beginTransaction();
        Student s = new Student();
//        s.setSid(1);
        s.setRank(2);
        s.setSemail("gavin@king.com");
        s.setSname("gavin");
        s.setSmarks(25);

        Student s2 = new Student();
        s2.setSid(2);
        s2.setRank(3);
        s2.setSemail("gavin1@king.com");
        s2.setSname("gavin1");
        s2.setSmarks(25);

        s1.persist(s);
        s1.persist(s2);
        //PK needs to be provided. if you try to persist 2 objects without pk, then it will fail. If you try to persist one
        // object without pk and save, the pk will be 0 and persisted.
        t.commit();
        s1.close();
        sf.close();
    }
}
