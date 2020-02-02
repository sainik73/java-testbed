package com.java.examples;

import com.java.examples.annotation.MyAnnotationExample;

import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(final String[] args) {

        final List<String> names = new ArrayList<String>();
        names.add("Java Annotation");
        Collections.sort(names);
        System.out.println("Welcome to the Java Tests");
        System.out.println("Please select a test:");

        for (int i = 0; i < names.size(); ++i) {
            System.out.print((char) ('a' + i));
            System.out.println(") " + names.get(i));
        }
        byte[] data = new byte[1];
        try {
            System.in.read(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (data[0]) {
            case 'a':
                MyAnnotationExample.main(args);
                break;
                default:
                    System.out.println("Invalid choice...");
        }
    }
}
