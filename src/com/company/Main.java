package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        long n = 5;
        String str = "Moscow";
        int[] numbers = {10, 20, 15};
        int fiboNum = 5;

        System.out.printf("Factorial of %d is %d\n", n, main.getFactorial(n));
        System.out.printf("Recursion Factorial of %d is %d\n", n, main.getFactorialRecursion(n));
        System.out.printf("Stream Factorial of %d is %d\n\n", n, main.getFactorialStream(n));

        System.out.printf("Reverse of %s is %s\n", str, main.getReverseStr(str));
        System.out.printf("StringBuffer Reverse of %s is %s\n\n", str, new StringBuffer(str).reverse());

        System.out.printf("Average of array is %f\n", getAverage(numbers));
        System.out.println("Stream Average of array is " + getAverageStream(numbers));
        System.out.println("Stream2 Average of array is " + getAverageStream2(numbers) + "\n");

        System.out.printf("%d Fibo is %d\n", fiboNum,getFibo(fiboNum));
        System.out.printf("%d Fibo Recursion is %d\n\n", fiboNum,getFiboRecursion(fiboNum));

        System.out.printf("Array of %d Fibo: ", fiboNum);
        printFiboArray(fiboNum);
    }

    private static void printFiboArray(int fiboNum) {
        long a = 0;
        long b = 1;
        long result = 0;

        System.out.print("0, 1, ");

        for (int i = 2; i < fiboNum; i++) {
            result = (a + b);
            a = b;
            b = result;
            if (i == fiboNum - 1) {
                System.out.print(result);
            } else {
                System.out.print(result + ", ");
            }
        }
    }

    private static long getFiboRecursion(int fiboNum) {
        return (4 > fiboNum) ? 1 : getFiboRecursion(fiboNum - 1) + getFiboRecursion(fiboNum - 2);
    }

    private static long getFibo(int fiboNum) {
        long a = 0;
        long b = 1;
        long result = 0;

        for (int i = 2; i < fiboNum; i++) {
            result = (a + b);
            a = b;
            b = result;
        }

        return b;
    }

    private static Double getAverageStream2(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }

    private static Double getAverageStream(int[] numbers) {
        return IntStream.of(numbers).average().getAsDouble();
    }

    private static double getAverage(int[] numbers) {
        double result = 0;

        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }

        return result/numbers.length;
    }

    private String getReverseStr(String str) {
        String reverseString = "";

        for (int i = 0; i < str.length(); i++) {
            reverseString = str.charAt(i) + reverseString;
        }

        return reverseString;
    }

    private long getFactorial(long n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private long getFactorialRecursion(long n) {
        return (2 > n) ? 1 : n * getFactorialRecursion(n - 1);
    }

    private long getFactorialStream(long n) {
        return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }
}