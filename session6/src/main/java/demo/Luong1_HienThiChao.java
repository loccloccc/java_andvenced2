package demo;

import java.util.Random;

public class Luong1_HienThiChao implements Runnable{

    @Override
    public void run(){
        while (true){
            Random r = new Random();
            while (true){
                System.out.println("So ngau nhien : " + r.nextInt(100));
            }
        }
    }
}
