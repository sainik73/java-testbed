package com.java.examples.streams;

import com.java.examples.function.Instructor;
import com.java.examples.function.Instructors;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class StreamsGroupingAndMappingExample {
    public static void main(String[] args) {

        //print the list of instructor names grouped by years of exp
        out.println("***** instructors grouped by years of exp ->");
        out.println(Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName,Collectors.toList()))));
        //print the list of instructors names grouped by online course
        out.println("***** instructors grouped by learning mode ->");
        Function<Instructor, String> courseType = instructor -> {
            if(instructor.isOnlineCourses()){
                return "Online";
            }else{
                return "Classroom";
            }
        };
        out.println(Instructors.getAll().stream()
                                   .collect(Collectors.groupingBy(courseType,
                                           Collectors.mapping(Instructor::getName,Collectors.toList()))));

        out.println("***** Most experienced instructor grouped by learning mode ->");
        out.println(Instructors.getAll().stream()
                .collect(Collectors.toMap(courseType, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Instructor::getYearsOfExperience)))));
        //all unique courses offered
        out.println("**** Total Unique Courses offered -> "+ Instructors.getAll().stream()
                                   .map(Instructor::getCourses)
                                   .flatMap(List::stream)
                                   .collect(Collectors.toSet()).size());
        out.println("**** List All courses offered by instructors -> ");
        out.println(Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .collect(Collectors.toSet()));
        //which courses are offered online versus classroom
        out.println("**** Total Courses offered by learning mode -> "+
                           Instructors.getAll().stream()
                           .collect(
                               Collectors.groupingBy(courseType,
                                   Collectors.collectingAndThen(
                                       Collectors.mapping(Instructor::getCourses,Collectors.toList())
                                       ,lists -> lists.stream().mapToLong(List::size).sum()))
                           ));
        out.println("**** Learning mode and courses offered -> ");
        Map<String,Set<String>> courseByLearningMode = Instructors.getAll().stream()
                .collect(
                        Collectors.groupingBy(courseType,
                                Collectors.collectingAndThen(
                                        Collectors.mapping(Instructor::getCourses,Collectors.toList())
                                        ,lists -> lists.stream().flatMap(List::stream).collect(Collectors.toSet()
            ))));

        out.println(courseByLearningMode.toString());

        out.println("**** Courses offered common across Classroom and Online Learning mode -> ");
        HashSet<String> classroomCourses = (HashSet<String>)courseByLearningMode.get("Classroom");
        HashSet<String> onlineCourses = (HashSet<String>)courseByLearningMode.get("Online");
        classroomCourses.stream().filter(onlineCourses::contains).forEach(out::println);
    }

}
