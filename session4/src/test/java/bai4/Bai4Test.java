package bai4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai4Test {
    private Bai4 bai4 = new Bai4();
    // mat khau manh
    @Test
    void checkPass(){
        String res = bai4.evaluatePasswordStrength("Abc123!@");
        assertEquals("Mat khau manh",res);
    }
    @Test
    void checkPasswordTrungBinh() {
        String res = bai4.evaluatePasswordStrength("abc12345");
        assertEquals("Trung binh", res);
    }

    @Test
    void checkPasswordYeu() {
        String res = bai4.evaluatePasswordStrength("Ab1!");
        assertEquals("Yeu", res);
    }
}