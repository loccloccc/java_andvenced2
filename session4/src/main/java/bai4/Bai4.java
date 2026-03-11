package bai4;

public class Bai4 {

    public String evaluatePasswordStrength(String password) {

        if (password.length() < 8) {
            return "Yeu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()].*");

        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Mat khau manh";
        }

        return "Trung binh";
    }
}