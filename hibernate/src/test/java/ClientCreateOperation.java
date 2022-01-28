import cache.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientCreateOperation {
    // first level cache
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
//        Student s1 = new Student();
//        s1.setSemail("s2@fakeemail.com");
//        s1.setSid(4);
//        s1.setSmarks(53);
//        s1.setSname("s2");
//        session.save(s1);
//        t.commit();
        session.close();
        sf.close();

//        Student student1 = (Student) s.get(Student.class, 1);
//        System.out.println(student1.getSname());
//        System.out.println(student1.getSemail());

//        Student student2 = (Student) s.get(Student.class, 1);
//        System.out.println(student2.getSname());
//        System.out.println(student2.getSemail());
    }
}
