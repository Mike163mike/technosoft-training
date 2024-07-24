package org.technosoft.test;

import org.technosoft.localdatetime.LocalDateTimeCustom;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("Random Integer: " + (int) (Math.random() * Integer.MAX_VALUE + 1));

        System.out.println("Random Long: " + (long) (Math.random() * Long.MAX_VALUE + 1));

        String maxSize = String.join("-", LocalDateTime.now().toString(), String.valueOf(Long.MAX_VALUE));
        System.out.printf("%s\nits length: %s%n", maxSize, maxSize.length());

        System.out.printf("Id = %d-%s", 1_000L, LocalDateTime.now());

        BigDecimal a = BigDecimal.valueOf(10.3);
        BigDecimal b = BigDecimal.valueOf(20.3);

        System.out.printf("\nBig Decimal divide: %s", a.divide(b, RoundingMode.HALF_UP));

        System.out.printf("\nBig Decimal multiply: %s", a.multiply(b));

        System.out.println("\n" + Integer.valueOf(String.valueOf(BigDecimal.TEN.setScale(0, RoundingMode.HALF_UP))));

        System.out.printf("\nAddition: a + b = %s", a.add(b).setScale(2, RoundingMode.HALF_UP));

    }
}
