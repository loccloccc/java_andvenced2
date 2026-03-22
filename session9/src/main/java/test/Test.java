package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demojavadven",
                    "root",
                    "duongloc2505"
            );
            Statement stmt = conn.createStatement();
            String create = """
                create table if not exists customers (
                    customer_id int primary key auto_increment,
                    customer_name varchar(100) not null,
                    phone varchar(20) unique not null,
                    address varchar(255)
                )
                """;
            stmt.execute(create);
            System.out.println("Table Created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
