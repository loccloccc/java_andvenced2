package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    protected String productName;
    protected double price;
    protected  String category;
    protected int quantity;

    public Product() {}

    public Product(String productId, String productName, double price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // ham nhap
    public void inputProduct(Scanner sc){
        // nhap id
        do {
            System.out.println("Nhap id cua san pham : ");
            this.productId = sc.nextLine();
            if (productId.trim().isEmpty() || !productId.matches("^P\\d{3}$")){
                System.out.println("ID khong duoc de trong va phai nhap dung dinh dang (vd : P001..).");
            }
        }while (productId.trim().equals("") || !productId.matches("^P\\d{3}$"));
        // nhap ten
        do {
            System.out.println("Nhap ten san pham : ");
            this.productName = sc.nextLine();
            if (productName.trim().equals("")){
                System.out.println("Ten san pham khong duoc de trong .");
            }
        }while (productName.trim().equals(""));
        //nhap gia
        do {
            System.out.println("Moi ban nhap gia san pham : ");
            this.price = sc.nextDouble();
            sc.nextLine();
            if (price < 0){
                System.out.println("Gia tien khong hop le.");
            }
        }while (price < 0);
        // nhap danh muc
        do {
            System.out.println("Nhap danh muc (ELECTRONICS / FOOD / FASHION) :");
            this.category = sc.nextLine();
            if (!(category.equalsIgnoreCase("ELECTRONICS") || category.equalsIgnoreCase("FOOD") || category.equalsIgnoreCase("FASHION"))){
                System.out.println("Chi nhap cac danh muc sau : ELECTRONICS / FOOD / FASHION ");
            }
        }while (!category.equalsIgnoreCase("ELECTRONICS") && !category.equalsIgnoreCase("FOOD") && !category.equalsIgnoreCase("FASHION"));
        // nhap so luong
        do {
            System.out.println("Nhap so luong san pham : ");
            this.quantity = sc.nextInt();
            sc.nextLine();
            if (quantity < 0){
                System.out.println("So luong san pham nhap vao khong hop le.");
            }
        }while (quantity < 0);
    }

    // ham in
    public void display(){
        System.out.printf("| Ma : %-20s | Ten san pham : %-20s | Gia : %-10.2f | Danh muc : %-20s | So luong %-5d |" , this.productId ,
                this.productName , this.price , this.category , this.quantity );
        System.out.println("");
    }
}
