package bai1;

import java.util.List;

public class Order {
    private String orderID;
    protected Customer customer;
    protected List<Product> productList;
    protected Double totalMoney;

    public Order() {
    }

    public Order(String orderID, Customer customer, List<Product> productList, Double totalMoney) {
        this.orderID = orderID;
        this.customer = customer;
        this.productList = productList;
        this.totalMoney = totalMoney;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getNameCustomer() {
        return customer;
    }

    public void setNameCustomer(Customer nameCustomer) {
        this.customer = nameCustomer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }


}
