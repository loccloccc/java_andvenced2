package bai2;

public class UserService {
    public boolean checkRegistrationAge(int age) throws IllegalAccessException {
        if (age < 0) throw new IllegalAccessException("Tuoi khong hop le");
        return age >= 18;
    }

}
