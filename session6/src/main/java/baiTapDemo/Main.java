package baiTapDemo;

public class Main {
    static void main(String[] args) {
//        bai1 bai1 = new bai1();
//        Thread t1 = new Thread(bai1);
//        t1.start();
            bai2 bai2 = new bai2();
        Thread t2 = new Thread(bai2);
        t2.start();
    }
}
