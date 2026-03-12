package miniPrj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("==============================");
        System.out.println("1 . . Thêm sản phẩm mới .");
        System.out.println("2 . Hiển thị danh sách sản phẩm .");
        System.out.println("3 . Cập nhật số lượng theo ID .");
        System.out.println("4 . Xóa sản phẩm đã hết hàng .");
        System.out.println("5 . Thoát chương trình");
        System.out.println("===============================");
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        ProductManager productManager = new ProductManager();
        int choice;
        do {
            menu();
            System.out.println("Lựa chọn của bạn :");
            choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice){
                    case 1:
                        // thêm
                        Product p = new Product();
                        System.out.println("Nhập ID : ");
                        p.setId(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Nhập tên sản phẩm : ");
                        p.setName(sc.nextLine());
                        System.out.println("Nhập giá sản phẩm : ");
                        p.setPrice(sc.nextDouble());
                        sc.nextLine();
                        System.out.println("Nhập số lượng tồn kho : ");
                        p.setQuantity(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Nhập tên danh mục : ");
                        p.setCategory(sc.nextLine());

                        productManager.addP(p);
                        break;
                    case 2:
                        productManager.display();
                        break;
                    case 3:
                        System.out.println("Nhập id bạn muốn cập nhật : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nhập số lượng muốn cập nhật : ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        productManager.update(id,quantity);
                        break;
                    case 4:
                        productManager.deleteOutOfStock();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình thành công");
                        break;
                    default:
                        System.out.println("Không có lựa chọn  này.....");
                }
            }catch (InvalidProductException e){
                System.out.println(e.getMessage());
            }


        }while (choice!=5);


    }
}
