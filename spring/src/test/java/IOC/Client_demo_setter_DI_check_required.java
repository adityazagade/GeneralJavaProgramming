package IOC;

import beans.setterDI_Required.Student;
import beans.setterDIchecking.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_demo_setter_DI_check_required {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/spring_di_setter_di_checking_required.xml");
        Student student = (Student) ctx.getBean("s");
        System.out.println(student.getName() + " " + student.getMarks() + " " + student.getEmail());
    }
}
