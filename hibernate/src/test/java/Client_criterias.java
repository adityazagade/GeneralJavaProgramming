import criterias.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import java.util.List;

public class Client_criterias {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("/criteria/oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Employee e1 = new Employee("e1", "e1@fakeemail.com", 1, 10000);
        Employee e2 = new Employee("e2", "e2@fakeemail.com", 2, 20000);
        Employee e3 = new Employee("e3", "e3@fakeemail.com", 3, 30000);
        Employee e4 = new Employee("e4", "e4@fakeemail.com", 4, 40000);
        Employee e5 = new Employee("e5", "e5@fakeemail.com", 5, 50000);

        s.persist(e1);
        s.persist(e2);
        s.persist(e3);
        s.persist(e4);
        s.persist(e5);

        t.commit();
        s.close();

        Session s1 = sf.openSession();
        Criteria c = s1.createCriteria(Employee.class);
        List<Employee> employees = c.list();
        employees.forEach(emp -> {
            System.out.println(emp.getEid() + " " + emp.getEname());
            return;
        });
        s1.close();

        // Select a particular Employee where id = 2;
        Session s3 = sf.openSession();
        Criteria c3 = s3.createCriteria(Employee.class);
        SimpleExpression r = Restrictions.eq("id", 2);
        c3.add(r);
        Employee ee = (Employee) c3.uniqueResult();
        System.out.println(ee.getEname() + " " + ee.getEid());
        s3.close();

        //Get data where salary > 8000;
        Session s4 = sf.openSession();
        Criteria c4 = s4.createCriteria(Employee.class);
        SimpleExpression r4 = Restrictions.gt("salary", 30000);
        c4.add(r4);
        List<Employee> sgtEmployeeList = c4.list();
        sgtEmployeeList.forEach(emp -> {
            System.out.println(emp.getEname() + " " + emp.getSalary());
            return;
        });
        s4.close();

        //get all names from employees
        Session s5 = sf.openSession();
        Criteria c5 = s5.createCriteria(Employee.class);
        PropertyProjection p = Projections.property("ename");
        c5.setProjection(p);
        List<String> empNames = c5.list();
        empNames.forEach(name -> {
            System.out.println(name);
            return;
        });

        s5.close();

        // get names and email both
        //get all names from employees
        Session s6 = sf.openSession();
        Criteria c6 = s6.createCriteria(Employee.class);
        ProjectionList pl = Projections.projectionList();
        PropertyProjection pName = Projections.property("ename");
        PropertyProjection pEmail = Projections.property("email");
        pl.add(pName);
        pl.add(pEmail);
        c6.setProjection(pl);
        List<Object> nameEmailList = c6.list();
        nameEmailList.forEach(obj -> {
            Object ar[] = (Object[]) obj;
            System.out.println(ar[0]);
            System.out.println(ar[1]);
            return;
        });
        s6.close();

        //AVERAGE SALARY
        Session s7 = sf.openSession();
        Criteria c7 = s7.createCriteria(Employee.class);
        AggregateProjection p7 = Projections.avg("salary");
        c7.setProjection(p7);
        double avgSalary = (double)c7.uniqueResult();
        System.out.println("avgSalary " + avgSalary);

        sf.close();



    }
}
