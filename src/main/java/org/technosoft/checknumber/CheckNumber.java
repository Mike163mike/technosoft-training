package org.technosoft.checknumber;

import java.util.Scanner;

public class CheckNumber {

    private static final String VERY_COLD = "veryCold";
    private static final String COLD = "cold";
    private static final String VERY_HOT = "veryHot";
    private static final String HOT = "hot";
    private static final String WIN = "win";

    public static int setLuckyNumber(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
    }

    public static boolean validateUsersNumber(int lowerBound, int upperBound, int userNumber) {
        return userNumber >= lowerBound && userNumber <= upperBound;
    }

    public static boolean validateBounds(int lowerBound, int upperBound) {
        return (upperBound - lowerBound) > 2;
    }

    public static String doGame(int lowerBound, int upperBound, int userNumber, int luckyNumber) {
        // int luckyNumber = setLuckyNumber(lowerBound, upperBound);
        int result = Math.abs(luckyNumber - userNumber);
        return switch (result) {
            case 0 -> WIN;
            case 1, 2 -> VERY_HOT;
            case 3, 4, 5 -> COLD;
            default -> VERY_COLD;
        };
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose bounds of the range.\n" +
                "Insert lower bound of range then click on the enter key: ");
        int lowerBound;
        while (true) {
            if (scanner.hasNextInt()) {
                lowerBound = scanner.nextInt();
                System.out.println("You set lower bound of the range as " + lowerBound + ".");
                break;
            } else {
                System.out.println("This is incorrect data. Try again.");
                scanner.next();
            }
        }
        System.out.print("Insert upper bound of range then click on the enter key: ");
        int upperBound;
        while (true) {
            if (scanner.hasNextInt()) {
                upperBound = scanner.nextInt();
                System.out.println("You set upper bound of the range as " + upperBound + ".");
                break;
            } else {
                System.out.println("This is incorrect data. Try again.");
                scanner.next();
            }
        }
        int luckyNumber = setLuckyNumber(lowerBound, upperBound);
        while (true) {
            int userNumber;
            while (true) {
                System.out.print("Now, choose your number from the range.\n" +
                        "Insert it and click the enter key: ");
                if (scanner.hasNextInt()) {
                    userNumber = scanner.nextInt();
                    System.out.println("You insert number " + userNumber + ".");
                    break;
                } else {
                    System.out.println("This is incorrect data. Try again.");
                    scanner.next();
                }
            }
            System.out.println("Let's take a look: you set the range between " + lowerBound + " and " + upperBound +
                    " then choose the number " + userNumber + ".");
            if (validateBounds(lowerBound, upperBound)) {
                System.out.println("Bounds of the range are valid.");
            } else {
                System.out.println("Upper bound should be bigger than lower. Try again.");
                continue;
            }
            if (validateUsersNumber(lowerBound, upperBound, userNumber)) {
                System.out.println("Your number valid too.");
            } else {
                System.out.println("Your number is out of bounds the range.");
                continue;
            }
            String resultOfGame = doGame(lowerBound, upperBound, userNumber, luckyNumber);
            System.out.println("\n***" + resultOfGame + "***\n");
            if (resultOfGame.equals(WIN)) {
                break;
            }
        }
    }
}
