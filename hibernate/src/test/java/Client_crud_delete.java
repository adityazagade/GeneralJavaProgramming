import crud.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_crud_delete {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("crud/oracle_delete.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        Student s1 = new Student();
        s1.setId(2);

        s.delete(s1);

        t.commit();
        s.close();
        sf.close();
    }
}