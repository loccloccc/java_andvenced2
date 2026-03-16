package bai1;

public class Customer {
    private String cusID;
    protected String nameCustomer;
    protected String email;
    protected String address;

    public Customer() {}

    public Customer(String cusID, String nameCustomer, String email, String address) {
        this.cusID = cusID;
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.address = address;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
