package com.java.examples.streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Purpose of this class is to sort the array using streams
 */
public class ArraySort {

    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "d", "y", "t", "e", "g", "v", "h"};

        System.out.println(Arrays.toString(Arrays.asList(strArray).stream().sorted((a1, a2) -> a1.compareTo(a2)).toArray()));

        //Stream factory method
        Stream<String> stringStream = Stream.of("a", "d", "y", "t", "e", "g", "v", "h");
        stringStream.sorted(Comparator.comparing(String::toString)).forEach(a -> System.out.println(a));

        //even numbers starting from 4 and next 10 numbers
        Stream<Integer> integerStream = Stream.iterate(4,i-> i+2).limit(10);
        integerStream.forEach(integer -> System.out.print(integer +", "));

        //print the joined stream
        System.out.println("---------------");
        System.out.println(Stream.of("a", "d", "y", "t", "e", "g", "v", "h").collect(Collectors.joining()));

        //print the joined stream with a delimiter
        System.out.println("---------------");
        System.out.println(Stream.of("a", "d", "y", "t", "e", "g", "v", "h").collect(Collectors.joining(":")));
    }
}
