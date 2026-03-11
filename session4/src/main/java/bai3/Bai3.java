package bai3;

public class Bai3 {
    public String checkEmail(String email) throws IllegalArgumentException {
        if (email.equals("")) return "Khong duoc de rong";
        if (!email.contains("@")) throw new IllegalArgumentException("Thieu @");
        if (!email.endsWith("gmail.com")) throw new IllegalArgumentException("Thieu ten mien ");
        return email.toLowerCase();
    }
}
