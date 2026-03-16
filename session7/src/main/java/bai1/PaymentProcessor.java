package bai1;

public class PaymentProcessor implements PaymentMethod{
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void pay(double money) {
        paymentMethod.pay(money);
    }
}
