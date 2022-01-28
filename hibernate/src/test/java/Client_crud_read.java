import crud.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_crud_read {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("crud/oracle_read.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Student s1 = (Student) s.get(Student.class, 30);
        if (s1 != null) {
            System.out.println(s1.getEmail());
        }

        Student s2 = s.load(Student.class,30);
        System.out.println(s2.getId());
//        System.out.println(s2.getEmail());
    }
}
