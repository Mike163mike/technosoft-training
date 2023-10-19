package org.technosoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

     private static  final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    static int[] array; //random int elements from -50 to 50. bounds included
    static int amountOfPositiveElements;
    static int amountOfNegativeElements;
    static int amountOfZeroElements;
    static int sumOfPositiveElements;
    static int sumOfNegativeElements;
    static double averageValue;

    public record PairImpl(int x, int y) {
    }

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
        System.out.println("""
                                
                30 random numbers from 0 to 1 000 (exclude): """);
        strings.forEach((string) -> System.out.print(string + ", "));
        System.out.println();

        System.out.println(String.join(", ", strings));
        System.out.println();

        System.out.println(String.join(",", strings));

        int[] data;
        data = new Random().ints(30, 0, 1_000)
                .toArray();
        System.out.print(Arrays.toString(data));

        RandomGenerator randomGenerator = new Random();
        randomGenerator.ints(1, 0, 100)
                .forEach((i) -> System.out.printf("\nRandom number: %s", i));

        randomGenerator.ints(30, 0, 100)
                .sorted()
                .forEach(System.out::print);

        System.out.println();
        System.out.println("RUB".matches("[A-Z]{3}") + " ~~~~~ Test string pattern matching.");

        System.out.println(convertStringToLocalDate("2023-10-22").plus(Duration.ofDays(1)));

        getQueriesByPeriod("2023-08-04 08:00", "2023-09-01 10:30");

        minusLocalDate(LocalDate.parse("2010-08-10"), LocalDate.parse("2020-10-10"));
        System.out.println();

        int i = 4;
        while (i > 0) {
            System.out.println("UUID: " + UUID.randomUUID());
            i--;
        }
        System.out.println("Checking list entry: " + checkList(List.of(new String[]{"role_admin"})));


    }

    public static LocalDateTime convertStringToLocalDate(String dateString) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var localDate = LocalDate.parse(dateString, formatter);
        return LocalDateTime.of(localDate, LocalTime.ofSecondOfDay(0));
    }

    public static void getQueriesByPeriod(String from, String to) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var localDateFrom = LocalDateTime.parse(from, formatter);
        var localDateTo = LocalDateTime.parse(to, formatter);
        System.out.println("DateTime From: " + localDateFrom + "\nTo: " + localDateTo);
    }

    public static void minusLocalDate(LocalDate start, LocalDate finish) {
        Period period = Period.between(start, finish);
        System.out.printf("%d года(лет) и %d месяц(а, ев)", period.getYears(), period.getMonths());
    }

    public static boolean checkList(List<String> roles) {
        final List<String> STRING_ROLES = List.of("ROLE_USER", "ROLE_ADMIN");
        LOGGER.info("Checked list: {}", STRING_ROLES);
       List<String> newStrings = roles.stream()
               .map(String::toUpperCase)
               .toList();
        return new HashSet<>(STRING_ROLES).containsAll(newStrings);
    }
}