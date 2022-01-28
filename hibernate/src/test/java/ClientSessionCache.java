import cache.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientSessionCache {
    // default is session level cache.
    // So when student1 and student2 is read from same session s1, the query fired is only once.

    // when same student is read from two sessions s1 and s2, the query fired twice.
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s1 = sf.openSession();
        Student student1 = (Student) s1.get(Student.class, 3);
//        Student student2 = (Student) s1.get(Student.class, 3);
        System.out.println(student1.getSname());
//        System.out.println(student2.getSname());

        Session s2 = sf.openSession();
        Student student3 = (Student) s2.get(Student.class, 3);
        System.out.println(student3.getSname());
    }
}
