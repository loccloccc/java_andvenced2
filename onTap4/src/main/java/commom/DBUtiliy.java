package commom;

import java.sql.*;

public class DBUtiliy {
    private static String FILE = "DB_Cate_Pro";
    private static String URL = "jdbc:mysql://localhost:3306/" + FILE;
    private static String user = "root";
    private static String password = "duongloc2505";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    // lay ham connection
    public static Connection getConnection() {
        Connection conn = null;
        // nap drive
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(URL,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    // ham dong
    public static void close(Connection conn , ResultSet rs , PreparedStatement pst){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {}
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {}
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {}
        }
    }

    static void main(String[] args) {
        getConnection();
    }
}
