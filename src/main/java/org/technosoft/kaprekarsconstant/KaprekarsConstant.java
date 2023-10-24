package org.technosoft.kaprekarsconstant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class KaprekarsConstant {

    /*Kaprekar's constant is 6174*/

    private static final Logger LOGGER = LoggerFactory.getLogger(KaprekarsConstant.class);

    /*method generates random number with range equals "range" and has no equals digits*/
    public int generateRandomNumber(double range) {
//        return (int) (Math.random() * (Math.pow(10, range) - Math.pow(10, range - 1)) + Math.pow(10, range - 1)) - 1;
        int randomInt;
        while (true) {
            randomInt = new Random().ints(1L, (int) Math.pow(10.0, range - 1), (int) Math.pow(10.0, range))
                    .findAny()
                    .orElse(0);
            int[] randomArr = intToIntArr(randomInt);
            int sum = randomArr[0];
            for (int j : randomArr) {
                sum -= j;
            }
            if (sum != 0) {
                return randomInt;
            }
        }
    }

    public int[] intToIntArr(int number) {
        String tmpStr = String.valueOf(number);
        char[] tmpChar = tmpStr.toCharArray();
        int[] tmpInt = new int[tmpChar.length];
        for (int i = 0; i < tmpChar.length; i++) {
            tmpInt[i] = Integer.parseInt(String.valueOf(tmpChar[i]));
        }
        return tmpInt;
    }

    public String arrayToStringByAsc(int[] number) {
        int[] tmpArr = Arrays.stream(number).sorted().toArray();
        return Arrays.stream(tmpArr).mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public String arrayToStringByDesc(int[] number) {
        int[] tmpArr = Arrays.stream(number).sorted().toArray();
        for (int i = 0; i < tmpArr.length / 2; i++) {
            int temp = tmpArr[i];
            tmpArr[i] = tmpArr[tmpArr.length - 1 - i];
            tmpArr[tmpArr.length - 1 - i] = temp;
        }
        return Arrays.stream(tmpArr).mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public int calculate(int[] numberAsArr, int pastConstant) {
        while (true) {
            int currentConstant = Integer.parseInt(arrayToStringByDesc(numberAsArr)) -
                    Integer.parseInt(arrayToStringByAsc(numberAsArr));
            if (pastConstant == currentConstant) {
                return currentConstant;
            }
            pastConstant = currentConstant;
            numberAsArr = intToIntArr(currentConstant);
            calculate(numberAsArr, pastConstant);
        }
    }

    public static void main(String[] args) {

        KaprekarsConstant kaprekarsConstant = new KaprekarsConstant();

        int number = 4;
        int pastConstant = 0;

        for (int i = 0; i < 10; i++) {
            int randomInt = kaprekarsConstant.generateRandomNumber(number);
            int[] numberAsArr = kaprekarsConstant.intToIntArr(randomInt);

//            System.out.println("RESULT (" + i + "): " + kaprekarsConstant.calculate(numberAsArr, pastConstant));
            LOGGER.info("RESULT ({}): {}", i, kaprekarsConstant.calculate(numberAsArr, pastConstant));
        }
    }
}
