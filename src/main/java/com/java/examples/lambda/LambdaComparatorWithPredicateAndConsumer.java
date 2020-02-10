package com.java.examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This call shows how to use functional interfaces provided in java.util.functions
 */
public class LambdaComparatorWithPredicateAndConsumer {

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
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()) );
        System.out.println(people);

        //Step 2: print all elements in the list
        System.out.println("print all elements in the list::");
        /* Java 8  lambda implementation */
        printConditionally(people, p -> true, p -> System.out.println(p));

    /* Java 7 implementation
    printConditionally(people, new Predicate<Person>() {
        @Override
        public boolean test(Person p) {
            return true;
        }
    });*/

        //Step 3: print all elements who have last name starting with S
        System.out.println("print all elements in the list who have last name starting with S::");
        /* Java 8  lambda implementation */
        printConditionally(people, p -> p.getLastName().startsWith("S"), p -> System.out.println(p.getFirstName()));

    /* Java 7 implementation
    printConditionally(people, new Predicate<Person>() {
        @Override
        public boolean test(Person p) {
            return p.getLastName().startsWith("S");
        }
    }); */

        //Step 4: Sort the list by age using BiConsumer
        System.out.println("Sort the list by age::");
        //List<String> newpeopleList = new ArrayList<>(people.size());
        List<Person> newpeopleList =customSort(people,(p1,p2) -> p1.getAge()< p2.getAge());
        System.out.println(newpeopleList);

        //Step 5: Sort the list by age using BiConsumer
        System.out.println("Sort the list by first name natural ordering::");
        newpeopleList =customSort(people,(p1,p2) -> p1.getFirstName().hashCode()< p2.getFirstName().hashCode());
        System.out.println(newpeopleList);
    }

    /**
     * This method uses BiFunction functional interface to provide a sorting behavior
     * The behavior of sorting is deferred to runtime and will be provided by caller.
     * @param people
     * @param booleanBiFunction
     * @return
     */
    public static List<Person> customSort(List<Person> people,
                                  BiFunction<Person,Person,Boolean> booleanBiFunction){
        List<Person> newPeople = new ArrayList<Person>(people.size());
        int i=0;
        Person p,t;
        for(;i<people.size()-1;i++){

                p = people.get(i);
                t= people.get(i+1);
                if(booleanBiFunction.apply(p,t)){
                    newPeople.add(p);
                    i= newPeople.size();
                };
            }

        return newPeople;
    }

    /**
     * This method prints the list elements based on the conditional evaluation based
     * on generic interface Predicate and Consumer
     * @param people
     * @param predicate This defines the condition to evaluate
     * @param consumer This defines the behavior to implement
     */
    public static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p: people){
            if(predicate.test(p)){
                //System.out.println(p.toString());
                consumer.accept(p);
            }
        }
    }




}
