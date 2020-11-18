package com.caimj.java.week05.jdbc;



import com.caimj.java.week05.bean.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用PreparedStatement实现增删改查
 * @author caimeijiao
 */
public class BatchJDBC {


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

    public void batchInsert(List<Student> list) {

        checkConn();

        String sql = "insert into test_student (id, name, sex, klassId) values (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            for (Student student : list) {
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getSex());
                ps.setInt(4, student.getKlassId());
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
    }

    public void batchUpdate(List<Student> list) {

        checkConn();

        String sql = "update test_student set name=? where id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            for (Student student : list) {
                ps.setString(1, student.getName());
                ps.setInt(2, student.getId());
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
    }

    public void batchDelete(List<Student> list) {

        checkConn();
        String sql = "delete from test_student where id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            for (Student student : list) {
                ps.setInt(1, student.getId());
                ps.addBatch();
            }
            ps.executeBatch();
//            ps.clearBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback(conn);
        } finally {
            close(conn);
        }
    }

    private void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        BatchJDBC batchJDBC = new BatchJDBC();
        batchJDBC.initConn();

        Student studentA = new Student(111, "caimj", "女", 1);
        Student studentB = new Student(111, "xpk", "女", 1);
        List<Student> list = new ArrayList<>();
        list.add(studentA);
        list.add(studentB);

        System.out.println("=========== insert ===========");
        batchJDBC.batchInsert(list);
        System.out.println("=========== update ===========");
        batchJDBC.batchUpdate(list);
        System.out.println("=========== delete ===========");
        batchJDBC.batchDelete(list);
    }
}

