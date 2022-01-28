import ORM.beans.Actor;
import ORM.beans.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Client_HAS_A_ONE_TO_MANY {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ORM/HAS_A_ONE_TO_MANY/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        Movie m1 = new Movie();
        m1.setMid(1);
        m1.setName("pk");

        Movie m2 = new Movie();
        m1.setMid(2);
        m1.setName("QSQT"); //Qayamat se Qayamat tak

        Set<Movie> movies = new HashSet<>();
        movies.add(m1);
        movies.add(m2);

        Actor ak = new Actor();
        ak.setaName("Aaamir");
        ak.setMovies(movies);

        session.save(ak);
        t.commit();
        session.close();
        sf.close();
    }
}
