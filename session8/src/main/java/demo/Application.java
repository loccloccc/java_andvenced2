package demo;

public class Application {
    static void main(String[] args) {
        // tạo log
        Log log1 = Log.getInstance();
        Log log2 = Log.getInstance();

        log1.log("Ứng dụng khởi động");
        log2.log("Người dùng đăng nhập");
    }
}
