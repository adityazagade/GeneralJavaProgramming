package dao.model;

import java.util.List;

public interface StudentBO {
    public void register(String name, String email, String addr);

    public void updateDetails(String oldEmail, String email, String addr);

    public List<Student> getListByGivenName(String name);

    public List<Student> getAllStudents();

    public void deleteStudent(Student st);

    // for jdbc, need to provide the id as the pk will be assumed as 0 and new records could not be updated.
    // OR we need to make a select * call to get the number of entries in the table first. Then use that info to create next PK
    // Here I will choose the first approach to pass the PK.
    public void register(int id, String name, String email, String addr);

}
