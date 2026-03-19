package rc.presentation;

import rc.business.CustomerBusiness;
import rc.entity.Customer;

import java.util.Scanner;

public class CustomerManager {
    static void main(String[] args) {
        CustomerBusiness customerBusiness = CustomerBusiness.getInstance();

        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("""
                    1. Hiển thị danh sách toàn bộ khách hàng .
                    2. Thêm mới khách hàng .
                    3. Cập nhập thông tin khách hàng theo mã .
                    4. Xóa khách hàng theo mã .
                    5. Tìm kiếm khách hàng theo tên . 
                    6. Lọc khách hàng theo loại .
                    7. Sắp xếp khách hàng theo tên tăng dần.
                    8. Thoát .
                    
                    Lựa chon của bạn : 
                    """);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                        customerBusiness.renderTable();
                    break;
                case 2:
                    while (true){
                        Customer customer = new Customer();
                        customer.inputData(sc);
                        customerBusiness.addCustomer(customer);
                        System.out.println("Bạn có muốn tiếp tục thêm khách hàng không (y/n) : ");
                        String answer = sc.nextLine();
                        if (!answer.trim().toLowerCase().equalsIgnoreCase("y")){
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập ID khách hàng bạn muốn cập nhật : ");
                    String id = sc.nextLine();
                    customerBusiness.updateCustomer(id,sc);
                    break;
                case 4:
                    System.out.println("Nhập ID khách hàng bạn muốn xóa : ");
                    String idDelete = sc.nextLine();
                    customerBusiness.deleteCustomer(idDelete);
                    break;
                case 5:
                    System.out.println("Nhập tên khách hàng bạn muốn tìm : ");
                    String nameSearch = sc.nextLine();
                    customerBusiness.searchName(nameSearch);
                    break;
                case 6:
                    System.out.println("Nhập loại khách hàng : ");
                    String type = sc.nextLine();
                    customerBusiness.filterCustomerType(type);
                    break;
                case 7:
                    customerBusiness.sortCustomerName();
                    break;
                case 8:
                    System.out.println("Thoát chương trình ...");
                    break;
                default:
                    System.out.println("Không có lựa chọn này...");

            }
        }while (choice!=8);
    }
}
