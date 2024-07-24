package org.technosoft.time_zone;

import java.time.*;
import java.util.List;

import static java.time.LocalDateTime.of;

public class TimeZones {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        ZonedDateTime zonedDateTimeInParis = now.atZone(zoneId);

        ZonedDateTime systemZonedDT = zonedDateTimeInParis.withZoneSameInstant(ZoneId.systemDefault());

        LocalDateTime localTime = systemZonedDT.toLocalDateTime();


        System.out.printf("\nTime in Paris: %s", zonedDateTimeInParis);

        System.out.printf("\nTime local: %s", now);

        System.out.printf("\nLocal Paris time: %s", localTime);

        System.out.printf("\nCreate LocalDateTime: %s", List.of(of(0, 1, 3, 0, 0)));

        System.out.printf("\nParse Duration: %s", List.of(Duration.ofDays(2), Duration.ofHours(5), Duration.ofMinutes(15)));

        System.out.printf("\nReverse: %s", Duration.parse("PT240H"));
    }


}
