package miniProSS9.Main;

import miniProSS9.Entity.*;
import miniProSS9.SaveData.ProductDatabase;
import miniProSS9.SaveData.ProductFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            menu();
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("======================");
                    System.out.println("1. Them Physical Product");
                    System.out.println("2. Them Digital Product");
                    System.out.println("======================");
                    System.out.print("Lua chon cua ban: ");

                    int type = sc.nextInt();
                    sc.nextLine();

                    Product p = ProductFactory.createProduct(type);

                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nhap ten san pham: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap gia san pham: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    p.setId(id);
                    p.setName(name);
                    p.setPrice(price);

                    if (p instanceof PhysicalProduct) {
                        System.out.print("Nhap trong luong: ");
                        double weight = sc.nextDouble();
                        sc.nextLine();
                        ((PhysicalProduct) p).setWeight(weight);

                    } else if (p instanceof DigitalProduct) {
                        System.out.print("Nhap dung luong: ");
                        int size = sc.nextInt();
                        sc.nextLine();
                        ((DigitalProduct) p).setSize(size);
                    }

                    ProductDatabase.getInstance().add(p);
                    System.out.println("Them san pham thanh cong!");

                    break;

                case 2:

                    ProductDatabase.getInstance().display();

                    break;

                case 3:

                    System.out.print("Nhap ID san pham can cap nhat: ");
                    String updateId = sc.nextLine();

                    System.out.println("1. Physical Product");
                    System.out.println("2. Digital Product");
                    int newType = sc.nextInt();
                    sc.nextLine();

                    Product newProduct = ProductFactory.createProduct(newType);

                    System.out.print("Nhap ten moi: ");
                    String newName = sc.nextLine();

                    System.out.print("Nhap gia moi: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    newProduct.setId(updateId);
                    newProduct.setName(newName);
                    newProduct.setPrice(newPrice);

                    if (newProduct instanceof PhysicalProduct) {
                        System.out.print("Nhap trong luong moi: ");
                        double weight = sc.nextDouble();
                        sc.nextLine();
                        ((PhysicalProduct) newProduct).setWeight(weight);

                    } else if (newProduct instanceof DigitalProduct) {
                        System.out.print("Nhap dung luong moi: ");
                        int size = sc.nextInt();
                        sc.nextLine();
                        ((DigitalProduct) newProduct).setSize(size);
                    }

                    ProductDatabase.getInstance().update(updateId, newProduct);

                    break;

                case 4:

                    System.out.print("Nhap ID san pham can xoa: ");
                    String deleteId = sc.nextLine();

                    ProductDatabase.getInstance().deletePro(deleteId);

                    System.out.println("Xoa thanh cong!");

                    break;

                case 5:
                    System.out.println("Thoat chuong trinh thanh cong...");
                    break;

                default:
                    System.out.println("Khong co lua chon nay!");
            }

        } while (choice != 5);
    }

    public static void menu() {

        System.out.println("=================================");
        System.out.println("1. Them san pham");
        System.out.println("2. Xem danh sach san pham");
        System.out.println("3. Cap nhat san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Thoat");
        System.out.println("=================================");
    }
}