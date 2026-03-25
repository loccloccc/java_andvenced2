package dao;

import entity.Book;

import java.util.List;

public interface BookDAO {
    // lấy danh sách sách
    List<Book> getAllBooks();

    // thêm sách mới
    boolean addBook(Book book);

    // cập nhật trạng thái
    boolean updateStatus(int id,String status);

    // trả sách và tính phí
    double returnBook(int id);
}
