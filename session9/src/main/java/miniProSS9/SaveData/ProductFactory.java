package miniProSS9.SaveData;

import miniProSS9.Entity.DigitalProduct;
import miniProSS9.Entity.PhysicalProduct;
import miniProSS9.Entity.Product;

import java.util.Objects;

public class ProductFactory {
    public static Product createProduct(int type){
        if (type == 1){
            return new PhysicalProduct();
        } else {
            return new DigitalProduct();
        }
    }
}
