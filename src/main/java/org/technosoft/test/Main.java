package org.technosoft.test;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println((long) (Math.random() * Integer.MAX_VALUE + 1));

        System.out.println(String.join("-",LocalDateTime.now().toString(), String.valueOf(100_000L)));
    }
}
