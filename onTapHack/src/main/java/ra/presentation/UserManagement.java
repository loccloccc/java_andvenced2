package ra.presentation;

import ra.business.UserBusiness;
import ra.entity.User;

import java.util.Scanner;

public class UserManagement {
    static void main(String[] args) {
        UserBusiness userBusiness = UserBusiness.getInstance();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    
                    1. Hiển thị danh sách toàn bộ người dùng
                    2. Thêm mới người dùng
                    3. Cập nhật thông tin người dùng theo mã
                    4. Xóa người dùng theo mã
                    5. Tìm kiếm người dùng theo tên
                    6. Lọc danh sách người dùng ADMIN
                    7. Sắp xếp danh sách theo điểm đánh giá giảm dần
                    8. Thoát
                    
                    """);
            System.out.println("Lua chon cua ban : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    userBusiness.renderTable();
                    break;
                case 2:
                    while (true){
                        User user = new User();
                        user.inputData(sc);
                        userBusiness.addUser(user);
                        System.out.println("Ban co muon them tiep khong (y/n) : ");
                        if (!sc.nextLine().equals("y")){
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhap id ban muon cap nhap : ");
                    String id = sc.nextLine();
                    userBusiness.update(id,sc);
                    break;
                case 4:
                    System.out.println("Nhap id ban muon xoa : ");
                    String id2 = sc.nextLine();
                    userBusiness.delete(id2);
                    break;
                case 5:
                    System.out.println("Nhap ten ban muon tim kiem : ");
                    String name = sc.nextLine();
                    userBusiness.searchName(name);
                    break;
                case 6:
                    userBusiness.filterAdmin();
                    break;
                case 7:
                    userBusiness.sortByScoreDesc();
                    break;
                case 8:
                    System.out.println("Thoat thanh cong");
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
            }
        }while (choice != 8);
    }
}
