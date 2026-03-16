package bai1;

public class CreditCardPayment implements PaymentMethod , CardPayable{
    @Override
    public void pay(double money) {
        cardPay(money);
    }

    @Override
    public void cardPay(double money) {
        System.out.println("Da thanh toan thanh cong : " + money + " bang the tin dung");
    }
}
