package dao.dao;

import dao.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl_jdbc_pool implements StudentDAO {
    DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int getCountOnTable(String tableName) throws Exception {
        Connection con = null;
        try {
            con = ds.getConnection();
            String sql = "select count(*) from " + tableName;
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            con.close();
            return count;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public int save(Student st) throws Exception {
        Connection con = null;
        try {
            con = ds.getConnection();
            String sql = "insert into student007 (id,name,email,address) values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, st.getId());
            stm.setString(2, st.getName());
            stm.setString(3, st.getEmail());
            stm.setString(4, st.getAddress());
            stm.execute();
            return st.getId();
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public boolean update(Student st) throws Exception {
        Connection con = null;
        try {
            con = ds.getConnection();
            String sql = "update student007 set email = ?, address = ? where id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, st.getEmail());
            stm.setString(2, st.getAddress());
            stm.setInt(3, st.getId());
            stm.execute();
            return true;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public boolean delete(Student st) throws Exception {
        Connection con = null;
        try {
            con = ds.getConnection();
            String sql = "delete from student007 where id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, st.getId());
                stm.execute();
            return true;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public List<Student> findAll() throws Exception {
        Connection con = null;
        List<Student> students = new ArrayList<>();
        try {
            con = ds.getConnection();
            String sql = "select * from student007";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student st;
                int id = rs.getInt(1);
                String sname = rs.getString(2);
                String mail = rs.getString(3);
                String addr = rs.getString(4);
                st = new Student(sname, mail, addr);
                st.setId(id);
                students.add(st);
            }
            return students;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public Student findByEmail(String email) throws Exception {
        Connection con = null;
        try {
            con = ds.getConnection();
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
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public List<Student> findByName(String name) throws Exception {
        Connection con = null;
        List<Student> students = new ArrayList<>();
        try {
            con = ds.getConnection();
            String sql = "select * from student007 where name=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student st;
                int id = rs.getInt(1);
                String sname = rs.getString(2);
                String mail = rs.getString(3);
                String addr = rs.getString(4);
                st = new Student(sname, mail, addr);
                st.setId(id);
                students.add(st);
            }
            return students;
        } finally {
            if (con != null) con.close();
        }
    }
}