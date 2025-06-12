package org.technosoft.localdatetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LocalDateTimeCustom localDateTimeCustom = new LocalDateTimeCustom();

        System.out.printf("Parse LocalDateTime: %s", localDateTimeCustom.convertLocalDateTimeToString(LocalDateTime.now()));

        System.out.printf("\nString parsers to LocalDateTime: %s", localDateTimeCustom.convertStringToLocalDateTime("12.05.2024 12:30"));

        System.out.printf("\nList of LocalDateTimes parsers to String:  %s",
                localDateTimeCustom.convertListLDTToString(List.of(LocalDateTime.now(), LocalDateTime.now().plusDays(1),
                        LocalDateTime.now().plusDays(2))));

        System.out.printf("\nParse String to LocalDateTime list: %s", localDateTimeCustom.convertStringToLDTList(
                "16.07.2024 14:43 , 17.07.2024 14:43 , 18.07.2024 14:43"));

        System.out.printf("%nSimple LDT: %s%n", LocalDateTime.now());

        System.out.printf("%nSimple ZDT: %s%n", ZonedDateTime.now());

        System.out.printf("%nSimple ODT: %s%n", localDateTimeCustom.convertODTToString(OffsetDateTime.now()));
    }
}
