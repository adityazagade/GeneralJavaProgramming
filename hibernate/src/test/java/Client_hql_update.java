import hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Client_hql_update {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hql/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

//        Student os1 = new Student(1,"os1@fakeemail.com","os1","os1_addr");

//        s.persist(os1);

//        String hql = "update Student set name='os2', email='os2@fakeemail.com' where id=1";
        String hql = "update Student set id=111 where id=1";
        Query q = s.createQuery(hql);
        int i = q.executeUpdate();
        System.out.println("Update successful: " + i);

        t.commit();
        s.close();
        sf.close();
    }
}
