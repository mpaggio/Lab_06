package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 100_000;
    private static final int TIMES = 1_000;
    private static final int START = 1_000;
    private static final int STOP = 2_000;
    private static long AFRICA_POPULATION = 1110635000L;
    private static long AMERICAS_POPULATION = 972005000L;
    private static long ANTARCTICA_POPULATION = 0L;
    private static long ASIA_POPULATION = 4298723000L;
    private static long EUROPE_POPULATION = 742452000L;
    private static long OCEANIA_POPULATION = 38304000L;

    private static void timeToString(String message, long nano, long milli){
        System.out.println(// NOPMD
            message
            + nano
            + "ns ("
            + milli
            + "ms)"
        );
    }

    private static void timeTestInsertHead(List<Integer> list){
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list.add(0,i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        timeToString("Adding 100.000 elements to the head of the list took ",time,millis);
    }

    private static void timeTestReadMiddle(List<Integer> list){
        long time = System.nanoTime();
        for (int i = 1; i <= TIMES; i++) {
            list.get(list.size()/2);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        timeToString("Reading 1.000 times the middle element from the list took ",time,millis);
    }

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> arrayList = new ArrayList<>();
        for (int i = START; i < STOP; i++){
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
        */
        final List<Integer> linkedList = new LinkedList<>(arrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
        */
        final Integer tmp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
        */
        for (final Integer tmpForEach : arrayList){
            System.out.println(tmpForEach);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        timeTestInsertHead(arrayList);
        timeTestInsertHead(linkedList);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        timeTestReadMiddle(arrayList);
        timeTestReadMiddle(linkedList);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> map = new HashMap<>();
        map.put("Africa", AFRICA_POPULATION);
        map.put("Americas", AMERICAS_POPULATION);
        map.put("Antarctica", ANTARCTICA_POPULATION);
        map.put("Asia", ASIA_POPULATION);
        map.put("Europe", EUROPE_POPULATION);
        map.put("Oceania", OCEANIA_POPULATION);

        /*
         * 8) Compute the population of the world
         */
        long populationOfTheWorld = 0;
        for (final Long value : map.values()){
            populationOfTheWorld = populationOfTheWorld + value;
        }
        System.out.println("Population of the world: " + populationOfTheWorld);
    }
}
