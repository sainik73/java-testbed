package com.java.examples;

import com.java.examples.annotation.MyAnnotationExample;
import com.java.examples.lambda.*;

import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(final String[] args) {

        final List<String> names = new ArrayList<String>();
        names.add("Java Annotation");
        names.add ("Java Lambda");

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
            case 'b':
                System.out.println("Lambda Greeter:");
                MyLambdaGreeter.main(args);
                System.out.println("*************************");
                System.out.println("Lambda Thread Runnable:");
                System.out.println("*************************");
                ThreadExampleWithLambda.main(args);
                System.out.println("*******************");
                System.out.println("Lambda Comparator:");
                System.out.println("*******************");
                PersonLambdaComparator.main(args);
                System.out.println("**********************************************");
                System.out.println("Lambda Comparator With Predicate And Consumer");
                System.out.println("**********************************************");
                LambdaComparatorWithPredicateAndConsumer.main(args);
                System.out.println("*************************");
                System.out.println("Lambda Streams Example");
                System.out.println("*************************");
                LambdaStreamsExample.main(args);
                break;
                default:
                    System.out.println("Invalid choice...");
        }
    }
}
