package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
    private static String URL = "jdbc:mysql://localhost:3306/library_db";
    private static String USER = "root";
    private static String PASSWORD = "duongloc2505";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
