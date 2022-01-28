import ORM.beans.Admin;
import ORM.beans.HEmployee;
import ORM.beans.SEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_IS_A_PER_CONCRETE_CLASS {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ORM/IS_A_CONCRETE_CLASS/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        SEmployee e1 = new SEmployee("se1", "se1@xyz.com", 1, 50000, "hibernate");
        HEmployee e2 = new HEmployee("he1", "he1@xyz.com", 2, 450000, 10);
        Admin e3 = new Admin("admin1", "admin1@xyz.com", 3, 40000, "Nerul");

        s.save(e1);
        s.save(e2);
        s.save(e3);

        t.commit();
        s.close();
        sf.close();
    }
}
