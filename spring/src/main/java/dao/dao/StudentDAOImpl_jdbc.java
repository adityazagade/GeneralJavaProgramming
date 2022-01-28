package dao.dao;

import dao.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl_jdbc implements StudentDAO {
    private String url = "jdbc:oracle:thin:@localhost:1521/AXEDAPDB";
    private String userName = "system";
    private String password = "Manager123";

    @Override
    public int save(Student st) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, password);
        String sql = "insert into student007 (id,name,email,address) values (?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, st.getId());
        stm.setString(2, st.getName());
        stm.setString(3, st.getEmail());
        stm.setString(4, st.getAddress());
        stm.execute();
        return st.getId();
    }

    @Override
    public boolean update(Student st) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, password);
        String sql = "update student007 set email = ?, address = ? where id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, st.getEmail());
        stm.setString(2, st.getAddress());
        stm.setInt(3, st.getId());
        stm.execute();
        return true;
    }

    @Override
    public boolean delete(Student st) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findByEmail(String email) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, password);
        String sql = "select * from student007 where email=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, email);
        ResultSet rs = stm.executeQuery();
        Student st = null;
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String mail = rs.getString(3);
            String addr = rs.getString(4);
            st = new Student(name, mail, addr);
            st.setId(id);
        }
        return st;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public int getCountOnTable(String tableName) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, password);
        String sql = "select count(*) from " + tableName;
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
}
