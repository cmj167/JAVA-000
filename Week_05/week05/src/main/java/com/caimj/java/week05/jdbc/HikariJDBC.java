package com.caimj.java.week05.jdbc;

import com.caimj.java.week05.bean.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class HikariJDBC {

    @Autowired
    private DataSource dataSource;

    public void insert(Student stu) {
        Connection conn = getConnection();
        String sql = "insert into test_student (id, name, sex, klass_id) values (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, stu.getId());
            ps.setString(2, stu.getName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
    }

    public void update(Student stu) {
        Connection conn = getConnection();
        String sql = "update test_student set name=? where id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, stu.getName());
            ps.setInt(2, stu.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
    }

    public void delete(int id) {
        Connection conn = getConnection();
        String sql = "delete from test_student where id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
    }

    public Student select(int id) {
        Student result = null;
        Connection conn = getConnection();
        String sql = "select id, name, sex, klass_id from test_student where id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String studentName = resultSet.getString("name");
                result = new Student();
                result.setId(studentId);
                result.setName(studentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
        return result;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void rollback(Connection conn) {
        if (null != conn) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void close(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyHikariConfig.class);
        HikariJDBC hikariJDBC = applicationContext.getBean(HikariJDBC.class);

        Student studentA = new Student(111, "caimj", "女", 1);
        Student studentB = new Student(111, "xpk", "女", 1);
        List<Student> list = new ArrayList<>();
        list.add(studentA);
        list.add(studentB);

        hikariJDBC.insert(studentA);
        hikariJDBC.update(studentB);
        System.out.println(hikariJDBC.select(111));
    }
}
