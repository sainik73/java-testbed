package com.java.examples.test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

public class TestStreamsSummaryStatistics {
    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats);
        DoubleStream doubleStream = DoubleStream.iterate(1.0, x -> x + 2).limit(10);
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
        System.out.println(doubleSummaryStatistics);
    }
}
