import ORM.beans.Vote;
import ORM.beans.Voter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Client_HAS_A_ONE_TO_ONE {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ORM/HAS_A_ONE_TO_ONE/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Voter v1 = new Voter();
        v1.setName("aditya");
        v1.setId(1);

        // i didn't set the id...
        Vote v = new Vote();
        v.setToCandidate("abc");
        v.setCastDate(new Date());
        v.setVoter(v1);

//        Vote vv = new Vote();
//        vv.setToCandidate("abcd");
//        vv.setCastDate(new Date());
//        vv.setVoter(v1);

        s.save(v1);
        s.save(v);
//        s.save(vv);  Exception in thread "main" org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [ORM.beans.Vote#1]

        t.commit();
        s.close();
        sf.close();
    }
}
