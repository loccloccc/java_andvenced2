package rc.business;

import rc.entity.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerBusiness {
    public static CustomerBusiness instance;

    public static CustomerBusiness getInstance() {
        if (instance==null) return instance = new CustomerBusiness();
        return instance;
    }

    // tao list
    List<Customer> list = new ArrayList<>();

    // hien thi
    public void renderTable(){
        if (list.isEmpty()){
            System.out.println("Danh sách rỗng .");
        }else {
            list.stream().forEach(Customer::displayData);
        }
    }


    // ham them moi
    public void addCustomer(Customer customer){
        // kiem tra id trung nhau
        boolean checkId = list.stream().anyMatch(c -> c.getCustomerID().equalsIgnoreCase(customer.getCustomerID()) && c.getEmail().equalsIgnoreCase(customer.getEmail()));
        if(checkId==true){
            System.out.println("Mã khách hàng hoặc email đã tồn tại .");
        }else{
            list.add(customer);
            System.out.println("Thêm khách hàng thành công");
        }
    }

    // ham cap nhat
    public void updateCustomer(String id , Scanner sc){
        Optional<Customer> customerOptional = list.stream().filter(c -> c.getCustomerID().trim().equals(id.trim())).findFirst();
        if (!customerOptional.isPresent()){
            System.out.println("Mã khách hàng không tồn tại .");
        }else{
            Customer customer = customerOptional.get();

            System.out.println("Cập nhật tên khách hàng : ");
            customer.setCustomerName(sc.nextLine());
            System.out.println("Cập nhật email khách hàng : ");
            customer.setEmail(sc.nextLine());
            System.out.println("Cập nhật số điên thoại khách hàng");
            customer.setPhone(sc.nextLine());
            System.out.println("Cập nhật loại khách hàng : ");
            customer.setCustomerType(sc.nextLine());

            System.out.println("Cập nhật thành công");
        }

    }

    // ham xoa
    public void deleteCustomer(String id){
        int size = list.size();

        list.removeIf(c -> c.getCustomerID().equals(id.trim()));

        if (size == list.size()){
            System.out.println("ID không hợp lệ");
        }
    }

    // tim kiem theo ten
    public void searchName(String name){
        List<Customer> list1 = list.stream()
                .filter(c -> c.getCustomerName().trim().equalsIgnoreCase(name.trim()))
                .collect(Collectors.toList());

        if (list1.isEmpty()){
            System.out.println("Tên " + name + " không tồn tại trong danh sách..");
        }else{
            list1.stream().forEach(Customer::displayData);
            System.out.println("Tổng : " + list1.size());
        }
    }

    // loc theo loai khach hang
    public void filterCustomerType(String type){
        List<Customer> list2 = list.stream()
                .filter(c -> c.getCustomerType().trim().equalsIgnoreCase(type.trim()))
                .collect(Collectors.toList());

        if (list2.isEmpty()){
            System.out.println("Loại khách hàng không hợp lệ hoặc không có");
        }else{
            list2.stream().forEach(Customer::displayData);
        }
    }

     // sap xep khach hang theo ten
    public void sortCustomerName(){
        list.stream()
                        .sorted(Comparator.comparing(Customer::getCustomerName));
        System.out.println("Danh sách sau khi sắp xêp : ");
        renderTable();
    }

}
