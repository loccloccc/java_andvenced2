package miniProSS9.Entity;

public class DigitalProduct extends Product{
    protected int size;

    public DigitalProduct() {}

    public DigitalProduct(String id, String name, double price, int size) {
        super(id, name, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void display(){
        System.out.println("Ten san pham : " + name + " | Gia san pham : " + price + " VND | Co kich thuoc : " + size);
    }
}
