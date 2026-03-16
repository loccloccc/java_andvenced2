package bai5;

import java.util.*;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private double finalTotal;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(OrderItem::getTotal).sum();
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setFinalTotal(double total){
        this.finalTotal = total;
    }

    public double getFinalTotal(){
        return finalTotal;
    }
}
