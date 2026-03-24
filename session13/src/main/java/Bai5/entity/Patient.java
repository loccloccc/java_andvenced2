package Bai5.entity;

public class Patient {

    private int id;
    private String name;
    private int age;
    private String bedId;

    public Patient(String name, int age, String bedId) {
        this.name = name;
        this.age = age;
        this.bedId = bedId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBedId() {
        return bedId;
    }
}