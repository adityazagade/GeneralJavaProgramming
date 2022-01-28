import ORM.beans.Admin;
import ORM.beans.HEmployee;
import ORM.beans.SEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_ORM_IS_A_Table_Per_SubClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ORM/IS_A_PerSubClass/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        SEmployee e1 = new SEmployee("se1", "se1@xyz.com", 1, 50000, "hibernate");
        HEmployee e2 = new HEmployee("he1", "he1@xyz.com", 2, 450000, 10);
        Admin e3 = new Admin("admin1", "admin1@xyz.com", 3, 40000, "Nerul");
        Transaction t = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(e3);
        t.commit();
        session.close();
        sf.close();
    }
}
