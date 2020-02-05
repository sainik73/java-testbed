package com.java.examples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonLambdaComparator {
    public static void main(String[] args) {
        List<Person> people= Arrays.asList(
                new Person("Charles","Dickins", 60),
                new Person("Adam", "Sandars", 35),
                new Person("Shawn","McDowell", 31),
                new Person("Thomas", "Carolle", 45),
                new Person("Carlie", "Smith", 27),
                new Person("Roger", "Bains", 61)
        );

        //Step 1: Sort the list by last name
        System.out.println("Sort the list by last name::");
        Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()) );
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
    }

    /**
     * This method prints the list elements based on the conditional evaluation
     * @param people
     * @param condition
     */
    public static void printConditionally(List<Person> people, Condition condition){
        for(Person p: people){
            if(condition.test(p)){
                System.out.println(p.toString());
            }
        }
    }
}

@FunctionalInterface
interface Condition{
    boolean test(Person p);
}
