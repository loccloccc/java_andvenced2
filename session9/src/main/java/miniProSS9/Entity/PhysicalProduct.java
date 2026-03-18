package miniProSS9.Entity;

public class PhysicalProduct extends Product{
    protected double weight;

    public PhysicalProduct() {
    }

    public PhysicalProduct(String id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void display(){
        System.out.println("Ten san pham : " + name + " | Gia san pham : " + price + " VND | Co trong luong : " + weight);
    }
}
