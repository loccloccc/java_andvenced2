package test;

import dao.DoctorDAO;
import dao.impl.DoctorDaoImpl;
import entity.Doctor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        // tạo DAO để gọi các chức năng database
        DoctorDAO dao = new DoctorDaoImpl();

        // Scanner để nhập dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);

        // format để chuyển String -> Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {

            // menu
            System.out.println("\n===== MENU QUAN LY BAC SI =====");
            System.out.println("1. Them bac si");
            System.out.println("2. Hien thi danh sach bac si");
            System.out.println("3. Sua thong tin bac si");
            System.out.println("4. Xoa bac si");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                // ================= CREATE =================
                case 1:

                    Doctor d = new Doctor();

                    System.out.print("Nhap ten bac si: ");
                    d.setDoctorName(sc.nextLine());

                    System.out.print("Nhap gioi tinh (true=Nam, false=Nu): ");
                    d.setGender(sc.nextBoolean());
                    sc.nextLine();

                    System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
                    Date date = sdf.parse(sc.nextLine());
                    d.setBirthday(date);

                    System.out.print("Nhap chuyen khoa: ");
                    d.setSpecialty(sc.nextLine());

                    System.out.print("Nhap so nam lam viec: ");
                    d.setYearWorkIn(sc.nextInt());

                    boolean result = dao.createDoctor(d);

                    if (result) {
                        System.out.println("Them bac si thanh cong!");
                    } else {
                        System.out.println("Them bac si that bai!");
                    }

                    break;


                // ================= READ =================
                case 2:

                    List<Doctor> list = dao.getDoctors();

                    System.out.println("\n===== DANH SACH BAC SI =====");

                    for (Doctor doc : list) {
                        System.out.println(doc);
                    }

                    break;


                // ================= UPDATE =================
                case 3:

                    Doctor update = new Doctor();

                    System.out.print("Nhap ID bac si can sua: ");
                    update.setDoctorId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nhap ten moi: ");
                    update.setDoctorName(sc.nextLine());

                    System.out.print("Nhap chuyen khoa moi: ");
                    update.setSpecialty(sc.nextLine());

                    boolean updateResult = dao.updateDoctor(update);

                    if (updateResult) {
                        System.out.println("Cap nhat thanh cong!");
                    } else {
                        System.out.println("Cap nhat that bai!");
                    }

                    break;


                // ================= DELETE =================
                case 4:

                    System.out.print("Nhap ID bac si can xoa: ");
                    int id = sc.nextInt();

                    boolean deleteResult = dao.deleteDoctor(id);

                    if (deleteResult) {
                        System.out.println("Xoa thanh cong!");
                    } else {
                        System.out.println("Xoa that bai!");
                    }

                    break;


                // ================= EXIT =================
                case 5:

                    System.out.println("Thoat chuong trinh...");
                    return;


                default:
                    System.out.println("Lua chon khong hop le!");

            }

        }

    }
}