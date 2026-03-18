package ra.entity;

import java.util.Scanner;

public class User {
    private String userId;
    protected String userName;
    protected int age;
    protected String role;
    protected double score;

    public User() {}

    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public void inputData(Scanner sc){
        // nhap id
        do {
            System.out.println("Nhap id : ");
            this.userId = sc.nextLine();
            if (!this.userId.matches("^U\\d{3}$")){
                System.out.println("Hay nhap lai ID theo dung dinh dang (U123) : ");
            }
        }while (!this.userId.matches("^U\\d{3}$"));
        // nhap ten
        do {
            System.out.println("Nhap ten : ");
            this.userName = sc.nextLine();
            if (userName.trim().isEmpty()){
                System.out.println("Khong duoc bo trong ten ..");
            }
        }while (userName.trim().isEmpty());
        // nhap tuoi
        do {
            System.out.println("Nhap tuoi : ");
            this.age = Integer.parseInt(sc.nextLine());
            if (age < 18){
                System.out.println("Tuoi phai lon hon 18");
            }
        }while (age < 18);
        // nhap role
        do {
            System.out.println("Nhap role (USER/ADMIN) :");
            this.role = sc.nextLine();
            if (!(role.equalsIgnoreCase("USER") || role.equalsIgnoreCase("ADMIN"))){
                System.out.println("Chi duoc nhap la USER hoac la ADMIN");
            }
        }while (!(role.equalsIgnoreCase("USER") || role.equalsIgnoreCase("ADMIN")));
        // nhap diem
        do {
            System.out.println("Nhap diem :");
            this.score = Double.parseDouble(sc.nextLine());
            if(score < 0 || score > 10){
                System.out.println("So diem nhap khong hop le");
            };
        }while (score < 0 || score > 10);

    }

    public void displayData(){
        System.out.printf("| %-20s | %-20s | %-10d | %-15s | %-10f " , this.userId , this.userName , this.age , this.role , this.score);
    }

}
