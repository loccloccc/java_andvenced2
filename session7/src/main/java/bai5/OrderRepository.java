package bai5;

import java.util.*;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public void save(Order order){
        orders.add(order);
    }

    public List<Order> findAll(){
        return orders;
    }
}