package ra.business;

import ra.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserBusiness {
    List<User> list = new ArrayList<>();

    public static UserBusiness instance;

    public static UserBusiness getInstance() {
        if (instance == null) return instance = new UserBusiness();
        return instance;
    }

    // hien thi danh sach
    public void renderTable(){
        if (list.isEmpty()){
            System.out.println("No Data..");
        }else {
            for (User x : list){
                x.displayData();
            }
        }
    }

    // themm nguoi dung
    public boolean addUser(User user){
        // check trung id
        boolean checkID = list.stream().anyMatch(u -> u.getUserId().equals(user.getUserId()));
        if (checkID == true){
            System.out.println("Ma nguoi dung da ton tai");
            return false;
        }
        list.add(user);
        return true;
    }

    // cap nhap theo id
    public void update(String id , Scanner sc){
        Optional<User> optionalUser = list.stream().filter(u -> u.getUserId().equals(id.trim())).findAny();
        if (!optionalUser.isPresent()){
            System.out.println("ID khong ton tai");
            return;
        }
        User user = optionalUser.get();

        System.out.println("Nhap ten : ");
        user.setUserName(sc.nextLine());

        System.out.println("Nhap tuoi : ");
        user.setAge(Integer.parseInt(sc.nextLine()));

        System.out.println("Nhap role : ");
        user.setRole(sc.nextLine());

        System.out.println("Nhap diem : ");
        user.setScore(Double.parseDouble(sc.nextLine()));


    }
    // tim kiem theo ten
    public void searchName(String name){
        List<User> usersList = list.stream().filter(u -> u.getUserName().toLowerCase().contains(name.trim().toLowerCase())).collect(Collectors.toList());
        if (usersList.isEmpty()){
            System.out.println("khong tim thay");
            return;
        }
        usersList.forEach(User::displayData);
    }

    // xoa nguoi dung
    public void delete(String id){
        int size = list.size();

        // xoa
        list.removeIf(u -> u.getUserId().equals(id.trim()));

        if (size == list.size()){
            System.out.println("Ma nguoi dung khong ton tai");
            return;
        }
    }

    public void filterAdmin() {
        List<User> admins = list.stream()
                .filter(u -> u.getRole().equals("ADMIN"))
                .collect(Collectors.toList());

        admins.forEach(User::displayData);
    }

    // ===================== 7. SORT =====================
    public void sortByScoreDesc() {
        list.stream()
                .sorted((u1, u2) -> Double.compare(u2.getScore(), u1.getScore()))
                .collect(Collectors.toList());
        renderTable();
    }
}
