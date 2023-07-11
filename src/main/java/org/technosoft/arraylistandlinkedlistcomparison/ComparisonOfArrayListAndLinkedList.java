package org.technosoft.arraylistandlinkedlistcomparison;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparisonOfArrayListAndLinkedList {
    public long calculateAddingDuration(List<Integer> list, int arrayLength) {
        var startTime = System.currentTimeMillis();
        while (arrayLength > 0) {
            list.add(arrayLength);
            arrayLength--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long calculateFetchingDuration(List<Integer> list, int amountOfFetch) {
        var startTime = System.currentTimeMillis();
        while (amountOfFetch > 0) {
            var temporaryIntIndex = (int) (Math.random() * (amountOfFetch + 1));
            list.get(temporaryIntIndex);
            amountOfFetch--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {

        var comparison = new ComparisonOfArrayListAndLinkedList();

        List<Integer> integerArrayList = new ArrayList<>();
        int arrayLength = 500_000;
        var durationOfArraylist = comparison.calculateAddingDuration(integerArrayList, arrayLength);
        System.out.printf("Duration of adding %,d elements in ArrayList is %,d ms.", arrayLength,
                durationOfArraylist);
        System.out.println();

        List<Integer> integerLinkedList = new LinkedList<>();
        var durationOfLinkedList = comparison.calculateAddingDuration(integerLinkedList, arrayLength);
        System.out.printf("Duration of adding %,d elements in LinkedList is %,d ms.", arrayLength,
                durationOfLinkedList);
        System.out.println();
        System.out.println();

        System.out.printf("Difference of durations these two methods is %,d ms. Arraylist is faster.",
                durationOfLinkedList - durationOfArraylist);
        System.out.println();
        System.out.println();

        int amountOfFetch = 50_000;
        var durationOfFetchingArray = comparison.calculateFetchingDuration(integerArrayList, amountOfFetch);
        var durationOfFetchingLinked = comparison.calculateFetchingDuration(integerLinkedList, amountOfFetch);
        System.out.printf("Duration of fetching random %,d elements from ArrayList with length = %,d is %,d ms.",
                amountOfFetch, amountOfFetch, durationOfFetchingArray);
        System.out.println();
        System.out.printf("Duration of fetching random %,d elements from LinkedList with length = %,d is %,d ms.",
                amountOfFetch, amountOfFetch, durationOfFetchingLinked);
        System.out.println();
        System.out.println();
        System.out.printf("Difference of durations these methods is %,d ms. ArrayList win again convincingly.",
                durationOfFetchingLinked - durationOfFetchingArray);
    }
}
