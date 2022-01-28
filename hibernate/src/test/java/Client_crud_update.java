import crud.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_crud_update {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("crud/oracle_update.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();

        Student st = new Student();
        st.setId(2);
        st.setName("abc");
        st.setMarks(0);
        // not setting email id to check if the email is kept as it or is set to null
        // res:  the email was made null.
        s.update(st);

        t.commit();
        s.close();

        System.out.println("Updatation successful");

        Session s2 = sf.openSession();
        Transaction t2 = s2.beginTransaction();
        // perform an get operation
        Student st2 = (Student) s2.get(Student.class, 2);

        // not perform an update operation
        st2.setEmail("abcd@xyz.com");
        s2.update(st2);
        t2.commit();
        s2.close();
        // The above update worked perfectly fine.

        Session s3 = sf.openSession();
        Transaction t3 = s3.beginTransaction();
        // perform an get operation
        Student st3 = (Student) s3.get(Student.class, 2);
        // now create another student with same id and call update.
        Student st4 = new Student();
        st4.setId(2);
        // s3.update(st4);
        // update call above fails with NonUniqueObjectException

        // lets try using merge
        s3.merge(st4);
        // great merge works perfectly fine. Merge works when you already have the object in memory and you want to update it.
        t3.commit();
        s3.close();

        sf.close();

    }
}
