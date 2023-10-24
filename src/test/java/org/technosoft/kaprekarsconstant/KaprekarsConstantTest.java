package org.technosoft.kaprekarsconstant;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class KaprekarsConstantTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(KaprekarsConstantTest.class);

    KaprekarsConstant kaprekarsConstant = new KaprekarsConstant();

    @RepeatedTest(value = 30)
    void generateRandomNumber() {
        var random = kaprekarsConstant.generateRandomNumber(4);
        LOGGER.info("random int: {}", random);
        assertTrue(1_000 < random && 10_000 >= random);
    }

    @RepeatedTest(value = 30)
    void calculate() {
        int randomInt = kaprekarsConstant.generateRandomNumber(4.0);
        int[] randomArr = kaprekarsConstant.intToIntArr(randomInt);
        int pastConstant = 0;

        assertEquals(6174, kaprekarsConstant.calculate(randomArr, pastConstant));
    }

    @Test
    void intToIntArr() {
        int tmpInt = 3560;

        assertArrayEquals(new int[]{3, 5, 6, 0}, kaprekarsConstant.intToIntArr(tmpInt));
    }

    @Test
    void arrayToStringByAsc() {
        var tmpArr = new int[]{2, 5, 0, 6};
        var tmpStr = "0256";

        assertEquals(tmpStr, kaprekarsConstant.arrayToStringByAsc(tmpArr));
        assertEquals(256, Integer.parseInt(kaprekarsConstant.arrayToStringByAsc(tmpArr)));
    }

    @Test
    void arrayToStringByDesc() {
        var tmpArr = new int[]{2, 5, 0, 6};
        var tmpStr = "6520";

        assertEquals(tmpStr, kaprekarsConstant.arrayToStringByDesc(tmpArr));
        assertEquals(6520, Integer.parseInt(kaprekarsConstant.arrayToStringByDesc(tmpArr)));
    }
}