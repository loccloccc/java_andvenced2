package bai1;

public class Bai1 {
    public boolean isValidUsername(String username){
        if (username.length() > 20 || username.length() < 6) return false;
        if (username == null) return false;
        if (username.equals("")) return false;
        return true;
    }
}
