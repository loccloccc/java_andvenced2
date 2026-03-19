package ra.presentation;

import ra.business.ProductBusiness;
import ra.entity.Product;

import java.util.Scanner;

public class ProductManagement {
    static void main(String[] args) {
        int choice;
        ProductBusiness productBusiness = ProductBusiness.getInstance();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    1. Hiển thị danh sách sản phẩm
                    2. Thêm sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm theo tên
                    6. Lọc sản phẩm ELECTRONICS
                    7. Sắp xếp theo giá giảm dần
                    8. Thoát
                    
                    Lựa chọn của bạn:
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    productBusiness.renderTable();
                    break;
                case 2:
                    while (true){
                        Product product = new Product();
                        product.inputProduct(sc);
                        productBusiness.add(product);
                        System.out.println("Ban co muon nhap them san pham khong :");
                        String answer = sc.nextLine();
                        if (!answer.equalsIgnoreCase("y")){
                            break;
                        }
                    }

                    break;
                case 3:
                    System.out.println("Nhap id ban muon cap nhat : ");
                    String id = sc.nextLine();
                    productBusiness.update(id,sc);
                    break;
                case 4:
                    System.out.println("Nhap id ban muon xoa : ");
                    String id1 = sc.nextLine();
                    productBusiness.deleteID(id1);
                    break;
                case 5:
                    System.out.println("Nhap ten san pham ban muon tim kiem : ");
                    String nameProduct = sc.nextLine();
                    productBusiness.searchName(nameProduct);
                    break;
                case 6:
                    productBusiness.filterProduc();
                    break;
                case 7:
                    productBusiness.sortPrice();
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
            }
        }while (choice!=8);
    }
}
