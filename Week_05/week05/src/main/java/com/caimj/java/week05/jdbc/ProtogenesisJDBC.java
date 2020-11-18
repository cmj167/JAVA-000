package com.caimj.java.week05.jdbc;

import com.caimj.java.week05.bean.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用原生jdbc实现增删改查
 * @author caimeijiao
 */
public class ProtogenesisJDBC {

    private Connection conn;

    /**
     * 初始化连接
     */
    public void initConn() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test", "test@123");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查连接
     */
    public void checkConn() {
        try {
            if (conn == null || conn.isClosed()) {
                initConn();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Student student) {

        checkConn();

        int result = 0;
        try (Statement stat = conn.createStatement()) {

            String sql = String.format("insert into test_student (id, name, sex, klass_id) values (%s, '%s', '%s', %s)",
                    student.getId(), student.getName(), student.getSex(), student.getKlassId());
            result = stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }

    public int update(Student student) {

        checkConn();

        int result = 0;
        try (Statement stat = conn.createStatement()) {

            String sql = String.format("update test_student set name='%s' where id=%s",
                    student.getName(), student.getId());
            result = stat.executeUpdate(sql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }

    public int delete(int id) {

        checkConn();

        int result = 0;
        try (Statement stat = conn.createStatement()) {

            String sql = String.format("delete from test_student where id=%s",
                    id);
            result = stat.executeUpdate(sql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }

    public Student query(int id) {

        checkConn();

        Student result = null;
        try (Statement stat = conn.createStatement()) {

            String sql = String.format("select id, name, sex, klass_id from test_student where id=%s",
                    id);
            ResultSet resultSet = stat.executeQuery(sql);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int klassId = resultSet.getInt("klass_id");

                result = new Student(id, name, sex, klassId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }

    public List<Student> queryAll() {

        checkConn();

        List<Student> result = new ArrayList<>();
        try (Statement stat = conn.createStatement()) {
            String sql = "select id, name, sex, klass_id from test_student";
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int klassId = resultSet.getInt("klass_id");

                Student stu = new Student(id, name, sex, klassId);
                result.add(stu);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
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

        ProtogenesisJDBC protogenesisJDBC = new ProtogenesisJDBC();
        protogenesisJDBC.initConn();

        Student studentA = new Student(111, "caimj", "女", 1);
        Student studentB = new Student(111, "xpk", "女", 1);

        System.out.println("insert :" + protogenesisJDBC.insert(studentA));
        System.out.println("query :" + protogenesisJDBC.query(111));
        System.out.println("update :" + protogenesisJDBC.update(studentB));
        System.out.println("queryAll :" + protogenesisJDBC.queryAll());
        System.out.println("delete :" + protogenesisJDBC.delete(111));
    }
}
