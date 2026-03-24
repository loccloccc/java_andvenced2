package entity;

import java.util.Date;

public class Doctor {

    // id bác sĩ
    private int doctorId;

    // tên bác sĩ
    private String doctorName;

    // giới tính
    private boolean gender;

    // ngày sinh
    private Date birthday;

    // chuyên khoa
    private String specialty;

    // số năm làm việc
    private int yearWorkIn;


    // constructor rỗng
    public Doctor() {
    }

    // constructor đầy đủ
    public Doctor(int doctorId, String doctorName, boolean gender, Date birthday, String specialty, int yearWorkIn) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.gender = gender;
        this.birthday = birthday;
        this.specialty = specialty;
        this.yearWorkIn = yearWorkIn;
    }

    // getter setter

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getYearWorkIn() {
        return yearWorkIn;
    }

    public void setYearWorkIn(int yearWorkIn) {
        this.yearWorkIn = yearWorkIn;
    }


    // in thông tin bác sĩ
    @Override
    public String toString() {
        return doctorId + " | " + doctorName + " | " + gender + " | " + birthday + " | " + specialty + " | " + yearWorkIn;
    }
}