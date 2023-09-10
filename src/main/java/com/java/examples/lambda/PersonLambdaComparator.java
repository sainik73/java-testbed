package com.java.examples.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PersonLambdaComparator {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickins", 60),
                new Person("Adam", "Sandars", 35),
                new Person("Shawn", "McDowell", 31),
                new Person("Thomas", "Carolle", 45),
                new Person("Carlie", "Smith", 27),
                new Person("Roger", "Bains", 61)
        );

        //Step 1: Sort the list by last name
        System.out.println("Sort the list by last name::");
        people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println(people);

        // Sort by last name descending
        System.out.println("Sort the list by last name descending::");
        people.sort((p1, p2) -> p2.getLastName().compareTo(p1.getLastName()));
        System.out.println(people);

        //Step 2: print all elements in the list
        System.out.println("print all elements in the list::");
        /* Java 8  lambda implementation */
        printConditionally(people, p -> true);

        /* Java 7 implementation
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return true;
            }
        });*/

        //Step 3: print all elements who have last name starting with S
        System.out.println("print all elements in the list who have last name starting with S::");
        /* Java 8  lambda implementation */
        printConditionally(people, p -> p.getLastName().startsWith("S"));

        /* Java 7 implementation
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("S");
            }
        }); */

        //print all persons less than 40
        System.out.println("Print all persons less than 40: ");
        Predicate<Person> predicate = o -> o.getAge() < 40;
        people.stream().filter(predicate).forEach(System.out::println);

        //print all persons for age descending
        System.out.println("print all persons for age descending");
        System.out.println("Original List:");
        people.forEach((p) -> System.out.print(p.toString() + "[" + p.age + "] "));
        System.out.println(" ");
        people.sort((p1, p2) -> Integer.compare(p2.age, p1.age));
        System.out.println(people);

    }

    /**
     * This method prints the list elements based on the conditional evaluation
     *
     * @param people
     * @param condition
     */
    public static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if (condition.test(p)) {
                System.out.println(p.toString());
            }
        }
    }

    @FunctionalInterface
    static
    interface Condition {
        boolean test(Person p);
    }
}
