package baiTapDemo;

import java.util.Random;

public class bai2 implements Runnable {
    String[] name = {"Loc" , "Duy" , "Minh" , "Khanh"};
    String[] address = {"Vinh Phuc" , "Me Linh" , "Thanh Hoa" , "Ha Noi"};

    Random r = new Random();
    @Override
    public void run(){
        while (true){
            String i = name[r.nextInt(name.length)];
            String j = address[r.nextInt(address.length)];

            System.out.println("Ten : " + i + " | Que quan " + j);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
