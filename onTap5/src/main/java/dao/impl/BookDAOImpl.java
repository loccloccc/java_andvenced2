package dao.impl;

import common.DBUtility;
import dao.BookDAO;
import entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    // 1. lấy danh sách sách
    @Override
    public List<Book> getAllBooks(){

        List<Book> list = new ArrayList<>(); // danh sách kết quả

        try{

            // mở kết nối
            Connection conn = DBUtility.getConnection();

            // câu lệnh sql
            String sql = "SELECT * FROM books";

            // tạo statement
            Statement stmt = conn.createStatement();

            // thực thi truy vấn
            ResultSet rs = stmt.executeQuery(sql);

            // duyệt từng dòng kết quả
            while(rs.next()){

                Book b = new Book();

                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setBorrower(rs.getString("borrower"));
                b.setBorrowDate(rs.getString("borrow_date"));
                b.setStatus(rs.getString("status"));

                list.add(b); // thêm vào list
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    // 2. thêm sách mới
    @Override
    public boolean addBook(Book book){

        try{

            Connection conn = DBUtility.getConnection();

            // PreparedStatement chống SQL Injection
            String sql="INSERT INTO books(title,borrower,borrow_date,status) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // gán tham số
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getBorrower());
            ps.setString(3,book.getBorrowDate());
            ps.setString(4,book.getStatus());

            ps.executeUpdate(); // chạy lệnh insert

            return true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    // 3. cập nhật trạng thái
    @Override
    public boolean updateStatus(int id,String status){

        try{

            Connection conn = DBUtility.getConnection();

            String sql="UPDATE books SET status=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,status);
            ps.setInt(2,id);

            ps.executeUpdate();

            return true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    // 4. gọi stored procedure
    @Override
    public double returnBook(int id){

        double fee = 0;

        try{

            Connection conn = DBUtility.getConnection();

            // CallableStatement dùng để gọi Stored Procedure
            CallableStatement cs =
                    conn.prepareCall("{CALL CALCULATE_LATE_FEE(?,?)}");

            // tham số IN
            cs.setInt(1,id);

            // đăng ký tham số OUT
            cs.registerOutParameter(2,Types.DOUBLE);

            // thực thi procedure
            cs.execute();

            // lấy kết quả OUT
            fee = cs.getDouble(2);

        }catch(Exception e){
            e.printStackTrace();
        }

        return fee;
    }
}