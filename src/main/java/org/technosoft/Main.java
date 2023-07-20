package org.technosoft;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static int[] array; //random int elements from -50 to 50. bounds included
    static int amountOfPositiveElements;
    static int amountOfNegativeElements;
    static int amountOfZeroElements;
    static int sumOfPositiveElements;
    static int sumOfNegativeElements;
    static double averageValue;


    public static void main(String[] args) {

        array = new int[50];
        System.out.print("Array with random int elements from -50 to 50: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = 50 - (int) (Math.random() * 101);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        amountOfPositiveElements = 0;
        for (int a : array) {
            if (a > 0) {
                amountOfPositiveElements++;
            }
        }
        System.out.println("Amount of positive elements: " + amountOfPositiveElements);

        amountOfNegativeElements = 0;
        for (int k : array) {
            if (k < 0) {
                amountOfNegativeElements++;
            }
        }
        System.out.println("Amount of negative elements: " + amountOfNegativeElements);

        amountOfZeroElements = 0;
        for (int j : array) {
            if (j == 0) {
                amountOfZeroElements++;
            }
        }
        System.out.println("Amount of zero elements: " + amountOfZeroElements);

        sumOfPositiveElements = 0;
        for (int l : array) {
            if (l > 0) {
                sumOfPositiveElements += l;
            }
        }
        System.out.println("Sum of all positive elements is " + sumOfPositiveElements);

        sumOfNegativeElements = 0;
        for (int s : array) {
            if (s < 0) {
                sumOfNegativeElements += s;
            }
        }
        System.out.println("Sum of all negative elements is " + sumOfNegativeElements);

        averageValue = (double) (sumOfPositiveElements + sumOfNegativeElements) / array.length;
        System.out.println("Average volume of elements: " + averageValue);

//        switch (amountOfZeroElements) {
//
//            case 10 -> System.out.println("it's grate!");
//            case 100 -> System.out.println("it's grate!");
//            case 10000 -> System.out.println("it's grate!");
//            case 10000000 -> System.out.println("it's grate!");
//
//            default -> throw new IllegalStateException("Unexpected value: " + amountOfZeroElements);
//        }
        List<String> strings;
        strings = Stream.generate(Math::random)
                .map(i -> (int) (i * 1_000))
                .map(Object::toString)
                .limit(30)
                .collect(Collectors.toList());

        strings.forEach(System.out::println);

        int[] data;
        data = new Random().ints(30, 0, 1_000)
                .toArray();
        System.out.print(Arrays.toString(data));



    }

}