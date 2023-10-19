package org.technosoft.checknumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckNumberTest {

    private static int luckyNumber;
    private static final int lowerBound = 10;
    private static final int upperBound = 30;

    @Test
    void setLuckyNumber() {
        int i = 10;
        while (i > 0) {
            int result = CheckNumber.setLuckyNumber(lowerBound, upperBound);
            Assertions.assertTrue(result <= upperBound && result >= lowerBound);
            i--;
        }
    }

    @Test
    void validateBounds() {
        boolean result = CheckNumber.validateBounds(lowerBound, upperBound);
        Assertions.assertTrue(result);
    }

    @Test
    void validateUsersNumber() {
        int userNumber = 20;
        boolean result = CheckNumber.validateUsersNumber(lowerBound, upperBound, userNumber);
        Assertions.assertTrue(result);
    }

    @Test
    void doGame() {
    }
}