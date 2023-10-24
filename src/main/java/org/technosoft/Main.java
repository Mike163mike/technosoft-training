package org.technosoft;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.technosoft.localdatetime.LocalDateTimeCastom;
import org.technosoft.rateofcurrency.RateOfCurrency;
import org.technosoft.rateofcurrency.jackson.CurrencyJackson;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    static int[] array; //random int elements from -50 to 50. bounds included
    static int amountOfPositiveElements;
    static int amountOfNegativeElements;
    static int amountOfZeroElements;
    static int sumOfPositiveElements;
    static int sumOfNegativeElements;
    static double averageValue;

    public record PairImpl(int x, int y) {
    }

    public static void main(String[] args) {

        array = new int[50];
        System.out.print("Array with random int elements from -50 to 50: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = 50 - (int) (Math.random() * 101);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        amountOfPositiveElements = 0;
        for (int a : array) {
            if (a > 0) {
                amountOfPositiveElements++;
            }
        }
        System.out.println("Amount of positive elements: " + amountOfPositiveElements);

        amountOfNegativeElements = 0;
        for (int k : array) {
            if (k < 0) {
                amountOfNegativeElements++;
            }
        }
        System.out.println("Amount of negative elements: " + amountOfNegativeElements);

        amountOfZeroElements = 0;
        for (int j : array) {
            if (j == 0) {
                amountOfZeroElements++;
            }
        }
        System.out.println("Amount of zero elements: " + amountOfZeroElements);

        sumOfPositiveElements = 0;
        for (int l : array) {
            if (l > 0) {
                sumOfPositiveElements += l;
            }
        }
        System.out.println("Sum of all positive elements is " + sumOfPositiveElements);

        sumOfNegativeElements = 0;
        for (int s : array) {
            if (s < 0) {
                sumOfNegativeElements += s;
            }
        }
        System.out.println("Sum of all negative elements is " + sumOfNegativeElements);

        averageValue = (double) (sumOfPositiveElements + sumOfNegativeElements) / array.length;
        System.out.println("Average volume of elements: " + averageValue);

//        switch (amountOfZeroElements) {
//
//            case 10 -> System.out.println("it's grate!");
//            case 100 -> System.out.println("it's grate!");
//            case 10000 -> System.out.println("it's grate!");
//            case 10000000 -> System.out.println("it's grate!");
//
//            default -> throw new IllegalStateException("Unexpected value: " + amountOfZeroElements);
//        }
        List<String> strings;
        strings = Stream.generate(Math::random)
                .map(i -> (int) (i * 1_000))
                .map(Object::toString)
                .limit(30)
                .collect(Collectors.toList());
        System.out.println("""
                                
                30 random numbers from 0 to 1 000 (exclude): """);
        strings.forEach((string) -> System.out.print(string + ", "));
        System.out.println();

        System.out.println(String.join(", ", strings));
        System.out.println();

        System.out.println(String.join(",", strings));

        int[] data;
        data = new Random().ints(30, 0, 1_000)
                .toArray();
        System.out.print(Arrays.toString(data));

        RandomGenerator randomGenerator = new Random();
        randomGenerator.ints(1, 0, 100)
                .forEach((i) -> System.out.printf("\nRandom number: %s", i));

        randomGenerator.ints(30, 0, 100)
                .sorted()
                .forEach(System.out::print);

        System.out.println();
        System.out.println("RUB".matches("[A-Z]{3}") + " ~~~~~ Test string pattern matching.");

        LocalDateTimeCastom localDateTimeCastom = new LocalDateTimeCastom();

        System.out.println(localDateTimeCastom.convertStringToLocalDate("2023-10-22").plus(Duration.ofDays(1)));

        localDateTimeCastom.getQueriesByPeriod("2023-08-04 08:00", "2023-09-01 10:30");

        localDateTimeCastom.minusLocalDate(LocalDate.parse("2010-08-10"), LocalDate.parse("2020-10-10"));
        System.out.println();

        int i = 4;
        while (i > 0) {
            System.out.println("UUID: " + UUID.randomUUID());
            i--;
        }
        System.out.println("Checking list entry: " + localDateTimeCastom.checkList(List.of(new String[]{"role_admin"})));
        System.out.println("=======================================================");

        RateOfCurrency rateOfCurrency = new RateOfCurrency();
        String json = rateOfCurrency.getCurrencies();
//        LOGGER.info("Json: {}", json);

//        Gson gson = new Gson();
////        Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDayTimeAdapter.class, new ZonedDayTimeAdapter()).create();
//        CurrencyGson currencies = gson.fromJson(json, CurrencyGson.class);
//        LOGGER.info("CurrencyXml object: {}", currencies);
//        LOGGER.info("""
//                Find "USD" {}""", currencies.findByCode("USD"));
//
//        String jsonFromCurrencies = gson.toJson(currencies);
//        LOGGER.info("""
//                To JSON from Object: {}""", jsonFromCurrencies);

        var jacksonMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        CurrencyJackson currencies;
        try {
             currencies = jacksonMapper.readValue(json, CurrencyJackson.class);
            LOGGER.info("""
                    JSON with Jackson library: {}""", currencies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            var stringJson = jacksonMapper.writeValueAsString(currencies);
            LOGGER.info("""
                    To JSON from Object: {}""", stringJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n=========================================================\n");
    }
}