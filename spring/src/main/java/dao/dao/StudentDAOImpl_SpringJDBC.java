package dao.dao;

import dao.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.Types;
import java.util.List;

public class StudentDAOImpl_SpringJDBC implements StudentDAO {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getCountOnTable(String tableName) {
        String sql = "select count(*) from " + tableName;
//        Integer count = jdbcTemplate.queryForObject(sql, (resultSet, i) -> resultSet.getInt(1));
//        if (count != null) {
//            return count;
//        } else {
//            return 0;
//        }
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int save(Student st) {
        String sql = "insert into student007 values (?,?,?,?)";
        // Creating params and passing no longer worked....
        // Instead directly pass the parameters into the jdbcTemplate.update() as arguments. Check other methods for example
        // Object param = new Object[]{st.getId(), st.getName(), st.getEmail(), st.getAddress()};
        jdbcTemplate.execute(sql, (PreparedStatementCallback<Boolean>) pst -> {
            pst.setInt(1, st.getId());
            pst.setString(2, st.getName());
            pst.setString(3, st.getEmail());
            pst.setString(4, st.getAddress());
            return pst.execute();
        });
        return st.getId();
    }

    @Override
    public boolean update(Student st) {
        String sql = "update student007 set email = ?, address = ? where id = ?";
//        Object param = new Object[]{st.getEmail(), st.getAddress(), st.getId()};
//        jdbcTemplate.execute(sql, (PreparedStatementCallback<Boolean>) pst -> {
//            pst.setString(1, st.getEmail());
//            pst.setString(2, st.getAddress());
//            pst.setInt(3, st.getId());
//            return pst.execute();
//        });
//        return true;

        int pk = jdbcTemplate.update(sql, st.getEmail(), st.getAddress(), st.getId());
        System.out.println("update pk: " + pk);
        return pk == 1;
    }

    @Override
    public boolean delete(Student st) {
        String sql = "delete from student007 where id = ?";
//        Object param = new Object[]{st.getId()};
        Boolean result = jdbcTemplate.execute(sql, (PreparedStatementCallback<Boolean>) pst -> {
            pst.setInt(1, st.getId());
            return pst.execute();
        });
        return result != null;
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student007";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String address = resultSet.getString(4);
            return new Student(id, name, email, address);
        });
    }

    @Override
    public Student findByEmail(String email) {
        String sql = "select * from student007 where email=?";
        return (Student) jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            int id = resultSet.getInt(1);
            String name1 = resultSet.getString(2);
            String mail = resultSet.getString(3);
            String address = resultSet.getString(4);
            return new Student(id, name1, mail, address);
        }, email);
    }

    @Override
    public List<Student> findByName(String name) {
        String sql = "select * from student007 where name=?";
//        Object param = new Object[]{};
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt(1);
            String name1 = resultSet.getString(2);
            String email = resultSet.getString(3);
            String address = resultSet.getString(4);
            return new Student(id, name1, email, address);
        }, name);
    }
}
