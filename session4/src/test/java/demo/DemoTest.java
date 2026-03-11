package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {
    private Demo demo = new Demo();
    @Test
    void sum() {
        assertEquals(10,demo.sum(5,5));
    }
}