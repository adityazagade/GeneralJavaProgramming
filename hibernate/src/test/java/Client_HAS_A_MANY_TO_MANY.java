import ORM.beans.Course;
import ORM.beans.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Client_HAS_A_MANY_TO_MANY {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ORM/HAS_A_MANY_TO_MANY/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        Course c1 = new Course();
        c1.setCid(1);
        c1.setFee(1500);
        c1.setName("Spring");

        Course c2 = new Course();
        c2.setCid(2);
        c2.setFee(1500);
        c2.setName("JPA");

        Course c3 = new Course();
        c3.setCid(3);
        c3.setFee(1500);
        c3.setName("Struts");

        Course c4 = new Course();
        c4.setCid(4);
        c4.setFee(1500);
        c4.setName("Hibernate");

        Set<Course> courseSet1 = new HashSet<>();
        courseSet1.add(c1);
        courseSet1.add(c2);
        courseSet1.add(c3);

        Set<Course> courseSet2 = new HashSet<>();
        courseSet2.add(c2);
        courseSet2.add(c3);
        courseSet2.add(c4);

        Faculty f1 = new Faculty();
        f1.setFid(1);
        f1.setName("Naveen");
        f1.setCourses(courseSet1);

        Faculty f2 = new Faculty();
        f2.setFid(2);
        f2.setName("Durga");
        f2.setCourses(courseSet2);

        session.save(f1);
        session.save(f2);
        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(c4);

        t.commit();
        session.close();
        sf.close();

    }
}
