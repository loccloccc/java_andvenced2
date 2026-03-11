package bai2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService = new UserService();
    @Test
    void checkRegistrationAge() throws IllegalAccessException {
        boolean res = userService.checkRegistrationAge(18);
        assertEquals(true,res);
    }

    @Test
    void testDuoi18() throws IllegalAccessException{
        boolean res = userService.checkRegistrationAge(15);
        assertEquals(false,res);
    }

    @Test
    void testNegativeAge_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.checkRegistrationAge(-1);
        });
    }
}