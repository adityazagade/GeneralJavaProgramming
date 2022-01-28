package DAO;

import dao.model.Student;
import dao.model.StudentBO;
import dao.model.StudentBO_impl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_test_pure_jdbc {
    public static void main(String[] args) {
        //either get it this way or , inject it using spring.
        // StudentBO sbo = new StudentBO_impl();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("dao/spring_pureJdbc.xml");
        StudentBO sbo = (StudentBO) ctx.getBean("sbo");

        //register student
        // Assume the inputs provided are name, email, addr;
        int id = 1;
        String name = "Aditya";
        String email = "iamazagade@fakeemail.com";
        String addr = "kolad";
        sbo.register(name, email, addr);

        id = 2;
        name = "Sagar";
        email = "spoth@fakeemail.com";
        addr = "khamb";
        sbo.register(name, email, addr);

        //update Student
        // imagine that we know the email ( could also be id) of the person whose details have to be known.
        sbo.updateDetails("spoth@fakeemail.com", "spothphode@fakeemail.com", "khamb");
    }
}
