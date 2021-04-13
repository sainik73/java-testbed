package com.java.examples.streams;

import com.java.examples.function.Instructor;
import com.java.examples.function.Instructors;

import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsGroupingAndMappingExample {
    public static void main(String[] args) {

        //print the list of instructor names grouped by years of exp
        System.out.println(Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName,Collectors.toList()))));
        //print the list of instructors names grouped by online course
        Function<Instructor, String> courseType = instructor -> {
            if(instructor.isOnlineCourses()){
                return "Online";
            }else{
                return "Classroom";
            }
        };
        System.out.println(Instructors.getAll().stream()
                .collect(Collectors.groupingBy(courseType,
                        Collectors.mapping(Instructor::getName,Collectors.toList()))));
    }
}
