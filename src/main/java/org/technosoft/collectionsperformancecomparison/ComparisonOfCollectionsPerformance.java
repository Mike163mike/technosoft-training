package org.technosoft.collectionsperformancecomparison;

import java.util.*;
import java.util.stream.Collectors;

public class ComparisonOfCollectionsPerformance {

    private final SortedMap<String, Long> performanceDuration = new TreeMap<>();

    public long calculateAddingDuration(Collection<Integer> list, int size) {
        var startTime = System.currentTimeMillis();
        while (size > 0) {
            list.add(size);
            size--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long calculateAddingDuration(Map<Integer, String> map, int size) {
        var startTime = System.currentTimeMillis();
        while (size > 0) {
            map.put(size, String.valueOf(size));
            size--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long calculateFetchingDuration(List<Integer> list, int amountOfFetch) {
        var startTime = System.currentTimeMillis();
        while (amountOfFetch > 0) {
            var temporaryIntIndex = (int) (Math.random() * (amountOfFetch + 1));
            list.remove(temporaryIntIndex);
            amountOfFetch--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long calculateFetchingDuration(Set<Integer> set, int amountOfFetch) {
        var startTime = System.currentTimeMillis();
        while (amountOfFetch > 0) {
            Integer temporaryInt = set.iterator().next();
            set.remove(temporaryInt);
            amountOfFetch--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long calculateFetchingDuration(Map<Integer, String> map, int amountOfFetch) {
        var startTime = System.currentTimeMillis();
        while (amountOfFetch > 0) {
            map.remove(amountOfFetch);
            amountOfFetch--;
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public Map<String, Long> rangeCollectionsByAdding(Map<String, Long> performanceDuration) {
        return performanceDuration.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new));
    }

    public void printPerformanceDuration() {
        for (Map.Entry<String, Long> map : rangeCollectionsByAdding(performanceDuration).entrySet()) {
            System.out.println(map.getKey() + ": " + String.format("%,d", map.getValue()) + " ms.");
        }
    }

    public static void main(String[] args) {

        var comparison = new ComparisonOfCollectionsPerformance();

        System.out.println("Comparative analysis of performance time different types collections by adding and " +
                "fetching " + "random elements.\n");
        List<Integer> integerArrayList = new ArrayList<>();
        int size = 500_000;
        var durationOfArraylist = comparison.calculateAddingDuration(integerArrayList, size);
        comparison.performanceDuration.put(integerArrayList.getClass().getSimpleName(), durationOfArraylist);
        System.out.printf("Duration of adding %,d elements in ArrayList is %,d ms.\n", size,
                durationOfArraylist);

        List<Integer> integerLinkedList = new LinkedList<>();
        var durationOfLinkedList = comparison.calculateAddingDuration(integerLinkedList, size);
        comparison.performanceDuration.put(integerLinkedList.getClass().getSimpleName(), durationOfLinkedList);
        System.out.printf("Duration of adding %,d elements in LinkedList is %,d ms.\n", size,
                durationOfLinkedList);

        Set<Integer> integerHashSet = new HashSet<>();
        var durationOfHashSet = comparison.calculateAddingDuration(integerHashSet, size);
        comparison.performanceDuration.put(integerHashSet.getClass().getSimpleName(), durationOfHashSet);
        System.out.printf("Duration of adding %,d elements in HashSet is %,d ms.\n", size,
                durationOfHashSet);

        Set<Integer> integerTreeSet = new TreeSet<>();
        var durationOfTreeSet = comparison.calculateAddingDuration(integerTreeSet, size);
        comparison.performanceDuration.put(integerTreeSet.getClass().getSimpleName(), durationOfTreeSet);
        System.out.printf("Duration of adding %,d elements in TreeSet is %,d ms.\n", size,
                durationOfTreeSet);

        Map<Integer, String> stringMap = new HashMap<>();
        var durationOfHashMap = comparison.calculateAddingDuration(stringMap, size);
        comparison.performanceDuration.put(stringMap.getClass().getSimpleName(), durationOfHashMap);
        System.out.printf("Duration of adding %,d elements in HashMap is %,d ms.\n\n", size,
                durationOfHashMap);

        System.out.print("""
                Durations of performance by adding elements in the different collections, arranged in decreasing
                order of performance:
                """);
        comparison.printPerformanceDuration();
        System.out.println();

        int amountOfFetch = 50_000;
        comparison.performanceDuration.clear();

        var durationOfFetchingArray = comparison.calculateFetchingDuration(integerArrayList, amountOfFetch);
        comparison.performanceDuration.put(integerArrayList.getClass().getSimpleName(), durationOfFetchingArray);

        var durationOfFetchingLinked = comparison.calculateFetchingDuration(integerLinkedList, amountOfFetch);
        comparison.performanceDuration.put(integerLinkedList.getClass().getSimpleName(), durationOfFetchingLinked);

        var durationOFetchingHashSet = comparison.calculateFetchingDuration(integerHashSet, amountOfFetch);
        comparison.performanceDuration.put(integerHashSet.getClass().getSimpleName(), durationOFetchingHashSet);

        var durationOfFetchingTreeSet = comparison.calculateFetchingDuration(integerTreeSet, amountOfFetch);
        comparison.performanceDuration.put(integerTreeSet.getClass().getSimpleName(), durationOfFetchingTreeSet);

        var durationOfFetchingHashMap = comparison.calculateFetchingDuration(stringMap, amountOfFetch);
        comparison.performanceDuration.put(stringMap.getClass().getSimpleName(), durationOfFetchingHashMap);

        System.out.printf("Duration of fetching and removing random %,d elements from ArrayList with size = %,d " +
                        "is %,d ms.\n",
                amountOfFetch, size, durationOfFetchingArray);
        System.out.printf("Duration of fetching and removing random %,d elements from LinkedList with size = %,d " +
                        "is %,d ms.\n",
                amountOfFetch, size, durationOfFetchingLinked);
        System.out.printf("Duration of fetching and removing %,d elements from HashSet with size = %,d is %,d ms.\n",
                amountOfFetch, size, durationOFetchingHashSet);
        System.out.printf("Duration of fetching and removing %,d elements from TreeSet with size = %,d is %,d ms.\n",
                amountOfFetch, size, durationOfFetchingTreeSet);
        System.out.printf("Duration of fetching and removing %,d elements from HashMap with size = %,d is %,d ms.\n\n",
                amountOfFetch, size, durationOfFetchingHashMap);

        System.out.printf("""
                Durations of performance by fetching and removing %,d elements in the different collections, arranged
                in decreasing order of performance:
                """, amountOfFetch);
        comparison.printPerformanceDuration();
        System.out.println();
        System.out.println("""
                    После многократного запуска программы для анализа скорости работы некоторых коллекций при добавлении
                    и при выборке с удалением элементов можно сделать следующие выводы:
                 1. Коллекция ArrayList показывает лучший результаты при добавлении в него элементов (в несколько раз
                    быстрее ближайшего конкурента) и один из худших при выборке с удалением;
                 2. Коллекция LinkedList показывает один из худший результатов при сравнении скорости выполнения как
                    при добавлении элементов так и при при выборке с удалением;
                 3. HashSet показывает один из лучших результатов в скорости работы при добавлении элементов  в
                    коллекцию и один из худших результатов в выборке с удалением;
                 4. HashMap показывает один из лучших результатов в выборке с удалением элементов (наравне с TreeSet)
                    (иногда метод даже округляет до 0 время работы HashMap, т. к. ему не хватает точности вычислений до
                    целых миллисекунд) и средний при добавлении элементов;
                """);
    }
}
