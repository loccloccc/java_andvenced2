package bai5;

public class ZaloPayPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán ZaloPay: " + amount);
    }
}
