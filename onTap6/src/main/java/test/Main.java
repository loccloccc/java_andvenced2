package test;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            // nap Drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            // ket noi voi DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","duongloc2505");
            if (conn != null) {
                System.out.println("ket noi thanhh cong");
            }

            Statement stm = conn.createStatement();
            String sql = "select *from Users";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("ID : " + id + " | Name : " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
