package bai1;

public class Product {
    private String proID;
    protected String proName;
    protected Double proPrice;

    public Product() {}

    public Product(String proID, String proName, Double proPrice) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }


}
