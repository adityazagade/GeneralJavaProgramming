package IOC;

import beans.setterDI.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_constructor_DI {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_di_constructor.xml");
        Student student = (Student) ctx.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
