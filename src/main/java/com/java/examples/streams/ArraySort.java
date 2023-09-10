package com.java.examples.streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Purpose of this class is to sort the array using streams
 */
public class ArraySort {

    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "d", "y", "t", "e", "g", "v", "h"};

        //System.out.println(Arrays.toString(Arrays.asList(strArray).stream().sorted((a1, a2) -> a1.compareTo(a2)).toArray()));
        //Optimized way to get stream from an array and reduce
        System.out.println(Stream.of(strArray).sorted().reduce((s, s2) -> s + " " + s2).get());

        //Sort stream using Stream factory method
        Stream<String> stringStream = Stream.of("a", "d", "y", "t", "e", "g", "v", "h");
        stringStream.sorted(Comparator.comparing(String::toString)).forEach(a -> System.out.print(a + " "));
        System.out.println("");

        //Stream of even numbers starting from 4 and next 10 numbers
        Stream<Integer> integerStream = Stream.iterate(4, i -> i + 2).limit(10);
        integerStream.forEach(integer -> System.out.print(integer + ", "));

        System.out.println(" ");
        //Create a int stream of 10 numbers
        IntStream intStream1 = IntStream.rangeClosed(0, 9);
        IntStream intStream2 = IntStream.range(10, 19);
        System.out.println("Int stream of 10 with range closed: " + intStream1.count());
        System.out.println("Int stream of 9 elements with range: " + intStream2.count());
        System.out.println("Concatenated streams : " + Arrays.toString(IntStream.concat(IntStream.rangeClosed(0, 9), IntStream.rangeClosed(0, 9)).toArray()));
        System.out.println("streams Average : " + IntStream.rangeClosed(0, 9).average().orElseThrow());
        int[] num = {1, 2, 3, 4, 5};
        System.out.println("Sorted int stream in descending order ");
        Arrays.stream(num).boxed().collect(Collectors.toList()).stream()
                .sorted((x1, x2) -> Integer.compare(x2, x1)).forEach(System.out::println);


        //print the joined stream
        System.out.println("");
        System.out.println("Joined Stream -> " +
                Stream.of("a", "d", "y", "t", "e", "g", "v", "h").collect(Collectors.joining()));

        //print the joined stream with a delimiter
        System.out.println("---------------");
        System.out.println("Joined Stream with a delimiter -> " +
                Stream.of("a", "d", "y", "t", "e", "g", "v", "h").collect(Collectors.joining(":")));
    }
}
