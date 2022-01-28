import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import primaryKeyGenerators.Employee;
import primaryKeyGenerators.Student;

public class Client_primaryKeyGenerators_custom {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("primaryKeyGenerators/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s1 = sf.openSession();
        Transaction t = s1.beginTransaction();

        Employee e = new Employee("aditya","mech","aditya@fakeemail.coma");
        String ok = (String) s1.save(e);
        t.commit();
        s1.close();
        sf.close();
    }
}
