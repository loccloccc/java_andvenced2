package dao;

import entity.Product;

import java.util.List;

public interface ProductDAO {
    // them san pham
    boolean addProduct(Product product);
    // lay danh sach san pham
    List<Product> getAllProducts();
    // cap nhap danh muc
    boolean updateProduct(Product product);
    // xoa danh muc theo id
    boolean deleteProduct(String product_id);
}
