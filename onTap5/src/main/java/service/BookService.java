package service;

import entity.Book;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    boolean addBook(Book book);

    boolean updateStatus(int id,String status);

    double returnBook(int id);

}
