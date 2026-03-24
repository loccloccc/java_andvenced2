package Bai5.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/rikkei_hospital";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Database connection failed!");
        }

        return conn;
    }
}