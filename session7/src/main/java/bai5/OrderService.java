package bai5;

import java.util.*;

public class OrderService {

    private OrderRepository repo;
    private NotificationService notification;

    public OrderService(OrderRepository repo, NotificationService notification) {
        this.repo = repo;
        this.notification = notification;
    }

    public void createOrder(Order order,
                            DiscountStrategy discount,
                            PaymentMethod payment){

        double total = order.getTotal();
        double finalTotal = discount.apply(total);

        order.setFinalTotal(finalTotal);

        payment.pay(finalTotal);

        repo.save(order);

        notification.send("success", order.getCustomer().getEmail());

        System.out.println("Đã lưu đơn hàng " + order.getId());
    }

    public List<Order> getOrders(){
        return repo.findAll();
    }

    public double getRevenue(){
        return repo.findAll()
                .stream()
                .mapToDouble(Order::getFinalTotal)
                .sum();
    }
}
