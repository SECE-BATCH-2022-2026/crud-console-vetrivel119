package org.bm.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {

    public static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        // Department table
        stmt.execute("CREATE TABLE IF NOT EXISTS department (" +
                "deptId INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50))");

        // Student table
        stmt.execute("CREATE TABLE IF NOT EXISTS student (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "rollNo INT, " +
                "name VARCHAR(50), " +
                "emailId VARCHAR(50), " +
                "deptId INT, " +
                "FOREIGN KEY(deptId) REFERENCES department(deptId))");

        // Course table
        stmt.execute("CREATE TABLE IF NOT EXISTS course (" +
                "courseId INT PRIMARY KEY AUTO_INCREMENT, " +
                "courseName VARCHAR(50), " +
                "courseCode VARCHAR(20))");

        // Grade table
        stmt.execute("CREATE TABLE IF NOT EXISTS grade (" +
                "gradeId INT PRIMARY KEY AUTO_INCREMENT, " +
                "studentId INT, " +
                "courseId INT, " +
                "mark1 INT, " +
                "mark2 INT, " +
                "mark3 INT, " +
                "totalMark INT, " +
                "averageMark INT, " +
                "FOREIGN KEY(studentId) REFERENCES student(id), " +
                "FOREIGN KEY(courseId) REFERENCES course(courseId))");

        stmt.close();
        System.out.println("Tables created successfully!");
    }
}
