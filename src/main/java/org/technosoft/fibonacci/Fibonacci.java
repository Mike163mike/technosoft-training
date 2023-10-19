package org.technosoft.fibonacci;

import java.util.Arrays;

public class Fibonacci {

    public Long[] calculate(Long firstNum, Long secondNum, int lengthOfArr) {
        Long[] fibonacciArr = new Long[lengthOfArr];
        fibonacciArr[0] = firstNum;
        fibonacciArr[1] = secondNum;
        for (int i = 2; i < lengthOfArr; i++) {
            fibonacciArr[i] = fibonacciArr[i-1] + fibonacciArr[i-2];
        }
        return fibonacciArr;
    }

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        System.out.println(Arrays.toString(fibonacci.calculate(0L, 1L, 20)));
    }
}
