package miniProSS9.SaveData;

import miniProSS9.Entity.DigitalProduct;
import miniProSS9.Entity.PhysicalProduct;
import miniProSS9.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDatabase {
    public static ProductDatabase instance;
    public ProductDatabase(){};
    public static ProductDatabase getInstance(){
        if (instance != null) return instance = new ProductDatabase();
        return instance;
    }
    protected List<Product> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    // them san pham
    public void add(Product p){
        list.add(p);
    }

    // cap nhat san pham
    public void update(String id , Product p){
        boolean flag = false;
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                flag = true;
                index = i;
                break;
            }
            flag = false;
        }
        if (flag == false) System.out.println("Khong tim thay san pham");
        list.set(index,p);
    }
    // xoa san pham
    public void deletePro(String id){
        for (Product p : list){
            if (p.getId().equals(id)){
                list.remove(p);
            }
        }
    }

    public void display(){
        for (Product p : list){
            if (p instanceof PhysicalProduct){
                ((PhysicalProduct) p).display();
            } else if (p instanceof DigitalProduct){
                ((DigitalProduct) p).display();
            }
        }
    }
}
