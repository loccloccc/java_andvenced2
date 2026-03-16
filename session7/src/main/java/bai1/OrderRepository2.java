package bai1;

public interface OrderRepository2 {
    void save(Order order);
    Order findOrderById(String id);
}
