package org.technosoft.localdatetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LocalDateTimeCustom {

    public LocalDateTime convertStringToLocalDate(String dateString) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var localDate = LocalDate.parse(dateString, formatter);
        return LocalDateTime.of(localDate, LocalTime.ofSecondOfDay(0));
    }

    public void getQueriesByPeriod(String from, String to) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var localDateFrom = LocalDateTime.parse(from, formatter);
        var localDateTo = LocalDateTime.parse(to, formatter);
        System.out.println("DateTime From: " + localDateFrom + "\nTo: " + localDateTo);
    }

    public void minusLocalDate(LocalDate start, LocalDate finish) {
        Period period = Period.between(start, finish);
        System.out.printf("%d года(лет) и %d месяц(а, ев)%n", period.getYears(), period.getMonths());
    }

    public boolean checkList(List<String> roles) {
        final List<String> STRING_ROLES = List.of("ROLE_USER", "ROLE_ADMIN");
//        LOGGER.info("Checked list: {}", STRING_ROLES);
        List<String> newStrings = roles.stream()
                .map(String::toUpperCase)
                .toList();
        return new HashSet<>(STRING_ROLES).containsAll(newStrings);
    }

    public boolean isBeforeDate(LocalDateTime localDateTime) {
        return localDateTime.isBefore(LocalDateTime.now());
    }

    public String convertLocalDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return localDateTime.format(formatter);
    }

    public LocalDateTime convertStringToLocalDateTime(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return LocalDateTime.parse(string, formatter);
    }

    public String convertListLDTToString(List<LocalDateTime> timeList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        return timeList.stream()
                .map(t -> t.format(formatter))
                .collect(Collectors.joining(" , "));
    }

    public List<LocalDateTime> convertStringToLDTList(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        return Arrays.stream(string.split(" , "))
                .map(t -> LocalDateTime.parse(t, formatter))
                .toList();
    }

    public String convertODTToString(OffsetDateTime offsetDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        return offsetDateTime.format(formatter);
    }
}

