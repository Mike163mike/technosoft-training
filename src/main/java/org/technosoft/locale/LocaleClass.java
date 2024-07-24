package org.technosoft.locale;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class LocaleClass {

    static Locale locale = Locale.US;

    public static void main(String[] args) {

        System.out.printf("Country: %s\n", locale.getCountry());
        System.out.printf("Language: %s\n", locale.getLanguage());
        System.out.printf("Currency: %s\n", NumberFormat.getCurrencyInstance(locale).getCurrency());

//        Arrays.stream(locale)
//                .forEach(System.out::println);
    }
}
