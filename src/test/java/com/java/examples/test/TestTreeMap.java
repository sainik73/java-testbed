package com.java.examples.test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.out;

public class TestTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

        map.put("20",1);
        map.put("1",1);
        map.put("10",1);
        map.put("5",1);

        map.forEach((k, v) -> out.print( k + "= " + v + ", "));
    }
}
