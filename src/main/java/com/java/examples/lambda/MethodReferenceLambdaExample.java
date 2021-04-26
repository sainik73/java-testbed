package com.java.examples.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceLambdaExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickins", 60),
                new Person("Adam", "Sandars", 35),
                new Person("Shawn", "McDowell", 31),
                new Person("Thomas", "Carolle", 45),
                new Person("Carlie", "Smith", 27),
                new Person("Roger", "Bains", 61)
        );

        //Step 1: print all elements in the list using method reference
        System.out.println("print all elements in the list::");
        /* Java 8  lambda implementation */
        //printConditionally(people, p -> true, p -> System.out.print(p));
        printConditionally(people, p -> true, System.out::println);

        //Step 2: print all elements in the list using method reference
        System.out.println("print all elements in the list by First Name::");
        /* Java 8  lambda implementation */
        printConditionally(people, p -> true, MethodReferenceLambdaExample::printFirstName);

        //Step3: print all elements using for each iteration
        System.out.println("print all elements using for each iteration:");
        //printConditionally(people, p -> true, people.forEach(System.out::println));
        people.forEach(System.out::println);


    }

    /* This method prints the list elements based on the conditional evaluation based
     * on generic interface Predicate and Consumer
     * @param people
     * @param predicate This defines the condition to evaluate
     * @param consumer This defines the behavior to implement
     */
    public static void printConditionally(List<Person> people, java.util.function.Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                //System.out.println(p.toString());
                consumer.accept(p);
            }
        }
    }

    public static void printFirstName(Person p) {
        System.out.print(p.getFirstName() + ",");
    }
}
