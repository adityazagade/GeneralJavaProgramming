import hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Client_hql_aggregateFunction {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hql/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        String selectAll = "select avg(marks) from Student";
        Session s5 = sf.openSession();
        Query q = s5.createQuery(selectAll);
        double average = (double) q.uniqueResult();
        System.out.println(average);
        s5.close();
        sf.close();
    }
}
