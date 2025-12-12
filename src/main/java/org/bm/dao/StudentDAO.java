package org.bm.dao;

import org.bm.pojo.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (rollNo, name, emailId, deptId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, student.getRollNo());
            pst.setString(2, student.getName());
            pst.setString(3, student.getEmailId());
            pst.setInt(4, student.getDeptId());
            pst.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getInt("rollNo"),
                        rs.getString("name"),
                        rs.getString("emailId"),
                        rs.getInt("deptId")
                );
                list.add(s);
            }
        }
        return list;
    }

    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getInt("rollNo"),
                        rs.getString("name"),
                        rs.getString("emailId"),
                        rs.getInt("deptId")
                );
            }
        }
        return null; // not found
    }

    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET rollNo=?, name=?, emailId=?, deptId=? WHERE id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, student.getRollNo());
            pst.setString(2, student.getName());
            pst.setString(3, student.getEmailId());
            pst.setInt(4, student.getDeptId());
            pst.setInt(5, student.getId());
            pst.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}
