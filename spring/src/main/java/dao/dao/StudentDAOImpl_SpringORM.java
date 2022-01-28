package dao.dao;

import dao.model.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl_SpringORM implements StudentDAO {

    HibernateTemplate htemplate;

    public void setHtemplate(HibernateTemplate htemplate) {
        this.htemplate = htemplate;
    }

    @Override
    public int save(Student st) {
        return (int) htemplate.save(st);
    }

    @Override
    public boolean update(Student st) {
        htemplate.update(st);
        return true;
    }

    @Override
    public boolean delete(Student st) {
        htemplate.delete(st);
        return true;
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) htemplate.find("from Student");
    }

    @Override
    public Student findByEmail(String email) {
        ArrayList<Student> list = (ArrayList<Student>) htemplate.find("from Student where email='" + email + "'");
        System.out.println(list.size());
        return list.get(0);
    }

    @Override
    public List<Student> findByName(String name) {
        return (List<Student>) htemplate.find("from Student where name='" + name + "'");
    }

    @Override
    public int getCountOnTable(String tableName) throws Exception {
        return 0;
    }
}
