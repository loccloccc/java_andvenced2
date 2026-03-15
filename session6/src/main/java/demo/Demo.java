package demo;

public class Demo {
    static void main(String[] args) {
        Luong1_HienThiChao obj = new Luong1_HienThiChao();
        Thread t1 = new Thread(obj);

        t1.start();

    }
}
