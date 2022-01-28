import hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Client_hql_select {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hql/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
//        Session s = sf.openSession();
//        Transaction t = s.beginTransaction();
//
//        Student os1 = new Student(1,"os1@fakeemail.com","os1","os1_addr");
//        Student os2 = new Student(2,"os2@fakeemail.com","os2","os2_addr");
//        Student os3 = new Student(3,"os3@fakeemail.com","os3","os3_addr");
//        Student os4 = new Student(4,"os4@fakeemail.com","os4","os4_addr");
//        Student os5 = new Student(5,"os5@fakeemail.com","os5","os5_addr");
//
//        s.persist(os1);
//        s.persist(os2);
//        s.persist(os3);
//        s.persist(os4);
//        s.persist(os5);
//
//        t.commit();
//        s.close();

//        Session s2 = sf.openSession();
//        String getEmployee = "from Student where id=1";
//        Query q = s2.createQuery(getEmployee);
//        Student ss = (Student) q.uniqueResult();
//        System.out.println(ss.getName() + " " + ss.getEmail());
//        s2.close();

//        String getAllNames = "select name from Student";
//        Session s3 = sf.openSession();
//        Query q = s3.createQuery(getAllNames);
//
//        List<String> names = q.list();
//        names.forEach(s -> System.out.println(s));
//        s3.close();


//        String getAllNames = "select name, email from Student";
//        Session s4 = sf.openSession();
//        Query q = s4.createQuery(getAllNames);
//
//        List<Object[]> combinedNameEmail = q.list();
//        combinedNameEmail.forEach(obj -> {
//            Object ar[] = obj;
//            System.out.println(ar[0]);
//            System.out.println(ar[1]);
//            return;
//        });
//        s4.close();

        String selectAll = "from Student";
        Session s5 = sf.openSession();
        Query q = s5.createQuery(selectAll);
        List<Student> allStudent = q.list();

        allStudent.forEach(s -> {
            System.out.println(s.getAddress() + " " + s.getEmail() + " " + s.getId() + " " + s.getName());
            return;
        });

        s5.close();

        sf.close();
    }
}
