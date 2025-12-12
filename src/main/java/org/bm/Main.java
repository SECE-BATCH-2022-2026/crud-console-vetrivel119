package org.bm;

import org.bm.dao.StudentDAO;
import org.bm.pojo.Student;
import org.bm.util.DBConnection;
import org.bm.util.DBInit;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
            System.out.println("H2 Console started at: http://localhost:8082");

            Connection conn = DBConnection.getConnection();
            System.out.println("Connection successful: " + (conn != null));

            DBInit.createTables(conn);

            conn.createStatement().execute("""
                MERGE INTO department (deptId, name)
                KEY (deptId)
                VALUES (1, 'Computer Science')
            """);
            System.out.println("Department ready.");


            StudentDAO studentDAO = new StudentDAO(conn);


            Student s1 = new Student(null, 101, "Vetri", "Vetri@gmail.com", 1);
            studentDAO.addStudent(s1);
            System.out.println("Inserted student: John Doe");


            List<Student> list = studentDAO.getAllStudents();
            System.out.println("\nAll Students:");
            for (Student s : list) {
                System.out.println(s.getId() + " | " + s.getName());
            }


            System.out.println("\nOpen H2 Console to view tables.");
            System.out.println("Press Ctrl+C to stop the application.");

            Thread.sleep(Long.MAX_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
