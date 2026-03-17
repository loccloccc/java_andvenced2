package demo2;

public class Log {
    // 1 . Tạo 1 biến static private
    private static Log instance;

    // 2 . constructor để private ngăn cho bên ngoài dùng tưd khóa new để tạo đối tượng
    private Log(){
        // khởi tạo kết nối tới file log
        System.out.println("Logger : khởi tạo");
    }


    // 3 . Cung cấp 1 phương thức static public để lấy ra thể hhieenj duy nhất đó
    public static Log getInstance(){
        if (instance == null){
            instance = new Log();
        }
        return instance;
    }

    // 4 phương thức xử lí log bình thường
    public void log(String message){
        System.out.println("LOG : " + message);
    }
}
