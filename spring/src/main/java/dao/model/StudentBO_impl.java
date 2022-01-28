package dao.model;

import dao.dao.StudentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentBO_impl implements StudentBO {
    StudentDAO stDAO;

    public void setStDAO(StudentDAO stDAO) {
        this.stDAO = stDAO;
    }

    @Override
    public List<Student> getListByGivenName(String name) {
        List<Student> students = null;
        try {
            students = stDAO.findByName(name);
        } catch (Exception e) {
            System.out.println("Could not get List of Students named " + name);
        }
        return students == null ? new ArrayList<Student>() : students;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = null;
        try {
            students = stDAO.findAll();
        } catch (Exception e) {
            System.out.println("Could not get List of Students");
        }
        return students == null ? new ArrayList<Student>() : students;
    }

    @Override
    public void deleteStudent(Student st) {
        try {
            stDAO.delete(st);
            System.out.println("Deletion successful");
        } catch (Exception e) {
            System.out.println("Deletion failed");
        }
    }

    @Override
    public void register(String name, String email, String addr) {
        // get the next Id for the student table;
        int count = 0;
        try {
            count = stDAO.getCountOnTable(Student.st_tb_name);
        } catch (Exception e) {
            System.out.println("Could not get next PK");
        }
        int id = count + 1;
        register(id, name, email, addr);
    }

    @Override
    public void updateDetails(String oldEmail, String email, String addr) {
        try {
            //get the Student detail by email first.
            Student st = stDAO.findByEmail(oldEmail);
            if (email != null) st.setEmail(email);
            if (addr != null) st.setAddress(addr);
            boolean success = stDAO.update(st);
            System.out.println("Updation successful " + success);
        } catch (Exception e) {
            System.out.println("Updation failed: " + e.getMessage());
        }
    }

    @Override
    public void register(int id, String name, String email, String addr) {
        Student st = new Student(name, email, addr);
        st.setId(id);
        try {
            int pk = stDAO.save(st);
            System.out.println("Student registered. Id: " + pk);
        } catch (Exception e) {
            System.out.println("Student registration failed ... " + e.getMessage());
        }
    }
}
