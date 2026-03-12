package miniPrj;

import java.util.ArrayList;
import java.util.Optional;

public class ProductManager {
    ArrayList<Product> list = new ArrayList<>();
    public void addP(Product p) throws  InvalidProductException{
        if (list.parallelStream().anyMatch(pro -> pro.getId() == p.getId())){
            throw new InvalidProductException("Loi trung ID");
        }
        list.add(p);
    }
    public void display(){
        list.parallelStream().forEach((Product p) -> System.out.println("Ma dinh danh : " + p.getId() + "| Ten san pham : " + p.getName() + " | So luong trong kho : " + p.getQuantity() + " | Gia san pham " + p.getPrice() + " | Ten danh muc : " + p.getCategory()));
    }
    public void update(int id , int quantity) throws  InvalidProductException{
        Optional<Product> opt = list.stream().filter(p -> p.getId() == id).findFirst();
        if (opt.isPresent()) {
            opt.get().setQuantity(quantity);
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm với ID: " + id);
        }
    }

    // Xóa sản phẩm có quantity = 0
    public void deleteOutOfStock() {
        list.removeIf(p -> p.getQuantity() == 0);
    }
}
