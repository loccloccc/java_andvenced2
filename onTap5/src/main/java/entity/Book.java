package entity;

public class Book {
    private int id; // id sách
    private String title; // tên sách
    private String borrower; // người mượn
    private String borrowDate; // ngày mượn
    private String status; // trạng thái

    public Book() {}

    public Book(int id, String title, String borrower, String borrowDate, String status) {
        this.id = id;
        this.title = title;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", borrower='" + borrower + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
