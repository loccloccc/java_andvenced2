package bai1;

public class MomoPayment implements PaymentMethod , EWalletPayable{
    @Override
    public void pay(double money) {
        eWall(money);
    }

    @Override
    public void eWall(double money) {
        System.out.println("Da thanh toan thanh cong : " + money + " bang vi MOMO");
    }
}
