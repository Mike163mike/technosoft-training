package org.technosoft.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    void calculate() {
        int lengthOfArr = 20;
        Long secondNum = 1L;
        Long firstNum = 0L;
        assertArrayEquals(new Long[]{0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L,
                        1597L, 2584L, 4181L},
        fibonacci.calculate(firstNum, secondNum, lengthOfArr));
    }
}