package main;

import entity.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        BookService service = new BookServiceImpl();

        while(true){

            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Mượn sách");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Trả sách & tính phí");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    List<Book> list = service.getAllBooks();

                    for(Book b : list){

                        System.out.println(
                                b.getId()+" | "+
                                        b.getTitle()+" | "+
                                        b.getBorrower()+" | "+
                                        b.getBorrowDate()+" | "+
                                        b.getStatus()
                        );

                    }

                    break;

                case 2:

                    Book b = new Book();

                    System.out.print("Tên sách: ");
                    b.setTitle(sc.nextLine());

                    System.out.print("Người mượn: ");
                    b.setBorrower(sc.nextLine());

                    System.out.print("Ngày mượn (YYYY-MM-DD): ");
                    b.setBorrowDate(sc.nextLine());

                    b.setStatus("BORROWED");

                    service.addBook(b);

                    break;

                case 3:

                    System.out.print("ID sách: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Status mới: ");
                    String status = sc.nextLine();

                    service.updateStatus(id,status);

                    break;

                case 4:

                    System.out.print("ID sách: ");
                    int bid = sc.nextInt();

                    double fee = service.returnBook(bid);

                    System.out.println("Phí trễ: "+fee);

                    break;

                case 5:

                    System.exit(0);

            }
        }
    }
}