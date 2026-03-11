package bai3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Bai3Test {
    private Bai3 bai3;
    static Scanner sc = new Scanner(System.in);
    @BeforeEach
    void setUp() {
        bai3 = new Bai3();
    }

    @Test
    void checkEmailThanhCong() throws IllegalAccessException {
        String res = bai3.checkEmail("user@gmail.com");
        assertEquals("user@gmail.com",res);
    }

    // thieu @
    @Test
    void checkACong() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class ,
                () -> bai3.checkEmail("userGmail.com")
        );
    }

    // khong co ten mien
    @Test
    void khongTenMien() throws  IllegalArgumentException{
        assertThrows(IllegalArgumentException.class ,
                () -> bai3.checkEmail("user@")
        );
    }

    // chuyen hoa email ve viet thuong
    @Test
    void vietEmailThuong() throws IllegalArgumentException{
        String res = bai3.checkEmail("Example@gmail.com");
        assertEquals("example@gmail.com" , res);
    }
}