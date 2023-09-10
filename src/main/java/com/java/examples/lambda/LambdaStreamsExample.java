package com.java.examples.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaStreamsExample {
    public static void main(String[] args) {
        // List of 10 persons
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickins", 60),
                new Person("Adam", "Sandars", 35),
                new Person("Mary", "Sandars", 35),
                new Person("Shawn", "McDowell", 31),
                new Person("Thomas", "Carolle", 45),
                new Person("Charles", "Smith", 27),
                new Person("Roger", "Doug", 61),
                new Person("Samantha", "Doug", 56),
                new Person("Charles", "Dickins", 60),
                new Person("Timmy", "Mitchell", 45)
        );

        //Step1: Count of Persons which have last name starting with 'D' with Lambda Streams
        System.out.println("Count of Persons which have last name starting with 'D':: " +
                people.parallelStream().filter(p -> p.getLastName().startsWith("D")).count()
        );

        //Step2: Print the distinct list based on first name
        System.out.println("Print the distinct list based on first name:: ");
        people.stream().distinct()
                .sorted((p1, t1) -> p1.getFirstName().compareTo(t1.getFirstName()))
                .forEach(System.out::println);

    }
}
