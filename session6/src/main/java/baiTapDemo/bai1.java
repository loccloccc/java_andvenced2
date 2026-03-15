package baiTapDemo;

import java.util.Random;

public class bai1 implements Runnable{
    String[] arr = {"Loc" , "Dung","Hoang","Huy","Linh"};
    Random random = new Random();
    public void run(){
        while (true){
            System.out.println("Ten ngau nhien : " + arr[random.nextInt(arr.length)]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
