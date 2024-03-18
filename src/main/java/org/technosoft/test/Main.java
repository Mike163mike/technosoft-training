package org.technosoft.test;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("Random Integer: " + (int) (Math.random() * Integer.MAX_VALUE + 1));

        System.out.println("Random Long: " + (long) (Math.random() * Long.MAX_VALUE + 1));

        String maxSize = String.join("-", LocalDateTime.now().toString(), String.valueOf(Long.MAX_VALUE));
        System.out.printf("%s\nits length: %s%n", maxSize, maxSize.length());

        System.out.printf("Id = %d-%s", 1_000L, LocalDateTime.now());
    }
}
