package org.technosoft.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

public class LocalDateTimeCastom {

    public  LocalDateTime convertStringToLocalDate(String dateString) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var localDate = LocalDate.parse(dateString, formatter);
        return LocalDateTime.of(localDate, LocalTime.ofSecondOfDay(0));
    }

    public  void getQueriesByPeriod(String from, String to) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var localDateFrom = LocalDateTime.parse(from, formatter);
        var localDateTo = LocalDateTime.parse(to, formatter);
        System.out.println("DateTime From: " + localDateFrom + "\nTo: " + localDateTo);
    }

    public  void minusLocalDate(LocalDate start, LocalDate finish) {
        Period period = Period.between(start, finish);
        System.out.printf("%d года(лет) и %d месяц(а, ев)", period.getYears(), period.getMonths());
    }

    public  boolean checkList(List<String> roles) {
        final List<String> STRING_ROLES = List.of("ROLE_USER", "ROLE_ADMIN");
//        LOGGER.info("Checked list: {}", STRING_ROLES);
        List<String> newStrings = roles.stream()
                .map(String::toUpperCase)
                .toList();
        return new HashSet<>(STRING_ROLES).containsAll(newStrings);
    }
}
