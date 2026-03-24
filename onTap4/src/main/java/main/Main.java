package main;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choiceManager , choiceCategory , choiceProduct;
        do {
            menuManager();
            choiceManager = input.nextInt();
            input.nextLine();
            switch (choiceManager){
                case 1:
                    do {
                        menuCategory();
                        choiceCategory = input.nextInt();
                        input.nextLine();
                        switch (choiceCategory){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Không có lựa chọn này ...");
                        }
                    }while (choiceCategory != 7);
                    break;
                case 2:

                    do {
                        menuProduct();
                        choiceProduct = input.nextInt();
                        input.nextLine();
                        switch (choiceProduct){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Không có lựa chọn này ...");
                        }
                    }while (choiceProduct!=7);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Không có lựa chọn này ...");
            }
        }while (choiceManager != 3);
    }

    public static void menuManager(){
        System.out.println("""
                ============== CATE PRO MANAGEMENT ==============
                1.Quản lý category .
                2.Quản lý product .
                3.Kết thúc .
                Lựa chọn của bạn : 
                """);
    }
    public static void menuCategory(){
        System.out.println("""
                ============= CATEGORY MANAGEMENT ============
                1.Danh sách categories .
                2.Thêm mới category .
                3.Cập nhật category .
                4.Xoá category (xoá mềm) .
                5.Tìm kiếm category theo tên (tìm kiếm tương đối) .
                6.Sắp xếp category theo tên .
                7.Trở lại .
                Lựa chọn của bạn : 
                """);
    }
    public static void menuProduct(){
        System.out.println("""
                =================== PRODUCT MANAGEMENT ==================
                1.Danh sách products .
                2.Thêm mới product .
                3.Cập nhật product .
                4.Tìm kiếm product .
                5.Xoá product .
                6.Sắp xếp danh sách giảm dần theo giá .
                7.Trở lại .
                Lựa chọn của bạn : 
                """);
    }
}
