import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Client_hql_delete {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hql/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        String hql = "delete Student where id=111";

        Query q = s.createQuery(hql);
        int i = q.executeUpdate();
        System.out.println("Number of rows affected: " + i);

        t.commit();
        s.close();
        sf.close();
    }
}
