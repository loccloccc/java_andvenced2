package bai1;

public class FixedDiscount implements DiscountStrategy{
    protected double money;

    public FixedDiscount(double money) {
        this.money = money;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - money;
    }
}
