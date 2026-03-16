package bai1;

import java.util.List;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double totalCaculateMoney(Order order){
        double total = 0;
        for (Product p : order.getProductList()){
            total += p.getProPrice();
        }
        return discountStrategy.applyDiscount(total);
    }
}
