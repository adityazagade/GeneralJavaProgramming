import crud.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_crud_create {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("crud/oracle_create.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session sess1 = sf.openSession();
        Transaction t = sess1.beginTransaction();

        Student s = new Student();
        s.setId(2);
        s.setEmail("a@fakeemail.com");
        s.setName("abcd");
        s.setMarks(50);

        int pk = (int) sess1.save(s);
        System.out.println("If you check DB, by now, no data is added to the DB");
        System.out.println("PK " + pk);
        t.commit();
        System.out.println("Data added successfully");
        System.out.println("If you try to save a student obj with pk that already exists, then it will throw constraints exception");

        sess1.close();

        Session s2 = sf.openSession();
        Transaction t2 = s2.beginTransaction();

        Student s1 = new Student();
        s1.setId(3);
        s1.setEmail("ab@fakeemail.com");
        s1.setName("abcde");
        s1.setMarks(50);

        s2.persist(s1);
        t2.commit();
        s2.close();

        sf.close();

//        There is also another method saveOrUpdate(). But I won't do an exmaple for the same. Its understood.
    }
}
