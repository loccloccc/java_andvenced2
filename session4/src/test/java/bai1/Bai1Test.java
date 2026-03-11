package bai1;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class Bai1Test {
    private Bai1 bai1 = new Bai1();

    @Test
    void isValidUsername() {
        String input = "loc";
        boolean res = bai1.isValidUsername(input);
        if (res == true){
            assertTrue(res);
        }else {
            assertFalse(res);
        }
    }
}