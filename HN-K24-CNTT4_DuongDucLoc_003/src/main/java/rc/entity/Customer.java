package rc.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Customer {
    private String customerID;
    protected String customerName;
    protected String email;
    protected String phone;
    protected String customerType;
    protected LocalDate registrationDate;

    public Customer() {}

    public Customer(String customerID, String customerName, String email, String phone, String customerType, LocalDate registrationDate) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.registrationDate = LocalDate.now();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void inputData(Scanner sc){
        // nhap id
        do {
            System.out.println("Nhập ID khách hàng :");
            this.customerID = sc.nextLine();
            if (!customerID.matches("^C\\d{3}$")){
                System.out.println("Lỗi : Nhập ID phải đúng định dang 'C100'.");
            }
        }while (!customerID.matches("^C\\d{3}$"));
        // nhap ten
        do {
            System.out.println("Nhập tên khách hàng : ");
            this.customerName = sc.nextLine();
            if (customerName.trim().isEmpty()){
                System.out.println("Không được để trống tên khách hàng.");
            }
        }while (customerName.trim().isEmpty());
        // nhap email
        do {
            System.out.println("Nhập email : ");
            this.email = sc.nextLine();
            if(!email.contains("@") || !email.contains(".")){
                System.out.println("Lỗi : Nhập email không đúng định dạng");
            }
        }while (!email.contains("@") || !email.contains("."));
        // nhap sdt
        do {
            System.out.println("Nhập số điện thoại : ");
            this.phone = sc.nextLine();
            if (!phone.startsWith("0") || phone.length() < 10){
                System.out.println("Số điện thoại không hợp lệ.");
            }
        }while(!phone.startsWith("0") || phone.length() < 10);
        // nhap loai khach hang
        do {
            System.out.println("Nhập loại khách hàng (Cá nhân,Doanh nghiệp,Ưu đãi) : ");
            this.customerType = sc.nextLine();
            if (!(customerType.trim().equalsIgnoreCase("Cá nhân") ||customerType.trim().equalsIgnoreCase("Doanh nghiệp") || customerType.trim().equalsIgnoreCase("Ưu đãi"))){
                System.out.println("Hãy nhập 3 loại khách hàng (Cá nhân | Doanh nghiệp | Ưu đãi)");
            }
        }while (!customerType.trim().equalsIgnoreCase("Cá nhân") && !customerType.trim().equalsIgnoreCase("Doanh nghiệp") && !customerType.trim().equalsIgnoreCase("Ưu đãi"));
        // nhap ngay thang
        this.registrationDate = LocalDate.now();
    }

    public void displayData(){
        System.out.println("======================================");
        System.out.println("Mã : " + this.customerID);
        System.out.println("Tên khách hàng : " + this.customerName);
        System.out.println("Email : " + this.email);
        System.out.println("So dien thoai : " + this.phone);
        System.out.println("Loại khách hàng : " + this.customerType);
        System.out.println("Ngày đăng kí : " + this.registrationDate);
        System.out.println("=======================================");
    }
}
