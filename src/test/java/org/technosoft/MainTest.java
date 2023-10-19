package org.technosoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

class MainTest {

    @Test
    void main() {
    }

    @Test
    void convertStringToLocalDate() {
        String dateString = "2023-10-12";
        Assertions.assertEquals(LocalDateTime.of(2023, Month.OCTOBER, 12, 0,0),
                Main.convertStringToLocalDate(dateString));
    }

    @Test
    void getQueriesByPeriod() {
    }

    @Test
    void minusLocalDate() {
    }

    @Test
    void checkList() {
        List<String> roles = List.of("ROLE_ADMIN");
        Assertions.assertTrue(Main.checkList(roles));
    }
}