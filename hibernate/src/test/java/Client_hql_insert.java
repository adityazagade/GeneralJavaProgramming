import hql.OldStudent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Client_hql_insert {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hql/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

//        OldStudent os1 = new OldStudent(1,"os1@fakeemail.com","os1","os1_addr");
//        OldStudent os2 = new OldStudent(2,"os2@fakeemail.com","os2","os2_addr");
//        OldStudent os3 = new OldStudent(3,"os3@fakeemail.com","os3","os3_addr");
//
//        s.persist(os1);
//        s.persist(os2);
//        s.persist(os3);

        String hql = "insert into NewStudent(id,name,email,address) select s.id,s.name,s.email,s.address from OldStudent s";

        Query q = s.createQuery(hql);
        int i = q.executeUpdate();
        System.out.println("Number of rows affected: " + i);

        t.commit();
        s.close();
        sf.close();
    }
}
