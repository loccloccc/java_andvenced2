package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDemo {
    private Demo demo = new Demo();
    @Test
    void sum() {
        assertEquals(12 , demo.sum(6,6));
    }
}