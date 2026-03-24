package comom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {

    // URL kết nối database
    private static final String URL = "jdbc:mysql://localhost:3306/medical_db";

    // user mysql
    private static final String USER = "root";

    // password mysql
    private static final String PASSWORD = "duongloc2505";


    // hàm lấy connection
    public static Connection getConnection() {

        Connection conn = null;

        try {
            // nạp driver mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            // tạo kết nối
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


    // hàm đóng connection để tránh leak bộ nhớ
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {

        try {

            // đóng resultset
            if (rs != null) {
                rs.close();
            }

            // đóng statement
            if (pst != null) {
                pst.close();
            }

            // đóng connection
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {
        System.out.println(getConnection());
    }
}