package dao.dao;

import dao.model.Student;

import java.util.List;

public interface StudentDAO {
    // pure jdbc, needs exception throwing ...
    int save(Student st) throws Exception;
    boolean update(Student st) throws Exception;
    boolean delete(Student st) throws Exception;
    List<Student> findAll() throws Exception;
    Student findByEmail(String email) throws Exception;
    List<Student> findByName(String name) throws Exception;
    int getCountOnTable(String tableName) throws Exception;
}
