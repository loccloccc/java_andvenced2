package bai1;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements OrderRepository2{
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public Order findOrderById(String id) {
        for (Order o : orders){
            if (o.getOrderID().equals(id)){
                return o;
            }
        }
        return null;
    }
}
