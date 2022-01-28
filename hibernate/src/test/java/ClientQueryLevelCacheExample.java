import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClientQueryLevelCacheExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("QueryLevelCacheEg/oracle_QueryLevelCahce.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        //insert some data in the table first.
//        Employee e1 = new Employee();
//        e1.setEid(1);
//        e1.setEname("e1");
//        e1.setEmail("e1@xyz.com");
//        e1.setSalary(500000);
//
//        Employee e2 = new Employee();
//        e2.setEid(2);
//        e2.setEname("e2");
//        e2.setEmail("e1@xyz.com");
//        e2.setSalary(500000);
//        session.save(e2);

        Query q = session.createQuery("select ename from Employee");
        q.setCacheable(true);
        List<String> list = q.list();
        list.forEach(name -> System.out.println(name));

        Query q1 = session.createQuery("select ename from Employee");
        q1.setCacheable(true);
        List<String> list1 = q1.list();
        list1.forEach(name -> System.out.println(name));

        t.commit();
        session.close();
        sf.close();
    }
}
