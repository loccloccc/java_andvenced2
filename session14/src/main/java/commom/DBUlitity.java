package commom;

import java.sql.*;

public class DBUlitity {
    private static String URL = "jdbc:mysql://localhost:3306/DB_ss14";
    private static String USER = "root";
    private static String PASSWORD = "duongloc2505";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn , ResultSet rs , PreparedStatement pst ){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {}
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {}
        }
        if(pst != null){
            try {
                pst.close();
            } catch (SQLException e) {}
        }
    }

    static void main(String[] args) {
        System.out.println(getConnection());
    }
}
