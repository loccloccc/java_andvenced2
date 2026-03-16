package bai1;

import java.util.Comparator;

public class CODPayment implements CODPayable , PaymentMethod {
    @Override
    public void pay(double money) {
        payCod(money);
    }

    @Override
    public void payCod(double money) {
        System.out.println("Da thanh toan COD " + money + " thanh cong" );
    }
}
