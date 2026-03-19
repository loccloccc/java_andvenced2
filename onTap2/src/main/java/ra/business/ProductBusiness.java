package ra.business;

import ra.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductBusiness {
    private static ProductBusiness instance;

    List<Product> list = new ArrayList<>();

    public static ProductBusiness getInstance() {
        if (instance == null) return instance = new ProductBusiness();
        return instance;
    }

    // hien thi
    public void renderTable(){
        if (list.isEmpty()){
            System.out.println("Khong co du lieu");
        }else {
//            for (Product p : list){
//                p.display();
//            }
            list.stream().forEach(Product::display);
        }

    }

    // them san pham
    public void add(Product product){
        boolean checkID = list.stream().anyMatch(p -> p.getProductId().equals(product.getProductId()));
        if (checkID== true){
            System.out.println("Ma SP da ton tai");
        }else {
            list.add(product);
            System.out.println("Them SP thanh cong");
        }
    }

    // cap nhap theo id;
    public void update(String id , Scanner sc){
        Optional<Product> optional = list.stream().filter(p -> p.getProductId().equals(id)).findFirst();
        if (!optional.isPresent()){
            System.out.println("ID khong ton tai");
        }else {
            Product product = optional.get();
            System.out.println("Nhap ten san pham : ");
            product.setProductName(sc.nextLine());
            System.out.println("Nhap gia san pham : ");
            product.setPrice(sc.nextDouble());
            sc.nextLine();
            System.out.println("Nhap danh muc (ELECTRONICS / FOOD / FASHION):");
            product.setCategory(sc.nextLine());
            System.out.println("Nhap so luong san pham :");
            product.setQuantity(sc.nextInt());
            sc.nextLine();
            System.out.println("Cap nhat thanh cong");
        }
    }

    // tim kiem theo ten
    public void searchName(String name){
        List<Product> products = list.stream().filter(u -> u.getProductName().toLowerCase().contains(name.toLowerCase().trim())).collect(Collectors.toList());
        if (products.isEmpty()){
            System.out.println("San pham ban tim khong ton tai");
        }
        products.forEach(Product::display);
    }
    // xoa theo id
    public void deleteID(String id){
        int size = list.size();

        list.removeIf(u -> u.getProductId().equals(id));

        if (size == list.size()) System.out.println("ID khong ton tai");
    }

    // loc san pham theo danh muc
    public void filterProduc(){
        List<Product> list1 = list.stream().filter(u -> u.getCategory().contains("ELECTRONICS")).collect(Collectors.toList());
        list1.forEach(Product::display);
    }

    // sap xep theo gia tien
    public void sortPrice(){
        list.stream().sorted((p1 , p2) -> Double.compare(p2.getPrice(),p1.getPrice())).collect(Collectors.toList());
        System.out.println("Sau khi sap xep");
        renderTable();
    }
}
