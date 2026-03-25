package service.impl;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import entity.Book;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    // gọi DAO
    BookDAO dao = new BookDAOImpl();

    public List<Book> getAllBooks(){
        return dao.getAllBooks();
    }

    public boolean addBook(Book book){
        return dao.addBook(book);
    }

    public boolean updateStatus(int id,String status){
        return dao.updateStatus(id,status);
    }

    public double returnBook(int id){
        return dao.returnBook(id);
    }
}
