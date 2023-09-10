package com.java.examples.function;

import java.util.List;

import static java.util.Arrays.asList;

public class Instructors {

    public static final String JAVA_PROGRAMMING = "Java Programming";
    public static final String SPRING_BOOT_2_RECIPES = "Spring Boot 2 Recipes";
    public static final String WEB_PROGRAMMING = "Web Programming";
    public static final String REACT_NATIVE = "React Native";

    public static List<Instructor> getAll() {
        Instructor instructor1 = new Instructor("Mike", "Lambert", 10, "Lead Software Engineer"
                , "M", true, asList(JAVA_PROGRAMMING, "C++ Programming", "Python Programming", SPRING_BOOT_2_RECIPES, WEB_PROGRAMMING, "Docker DevOps", "Kubernetes"));

        Instructor instructor2 = new Instructor("Jenny", "Moore", 5, "Sr Software Engineer"
                , "F", false, asList(JAVA_PROGRAMMING, "Java Multi-Threaded Programming", "CI/CD", "Unit Testing"));

        Instructor instructor3 = new Instructor("Gene", "Chateau", 6, "Software Engineering Manager"
                , "M", false, asList("C++ Programming", "C Programming", REACT_NATIVE, "Redux State Management", "Full Stack Development"));

        Instructor instructor4 = new Instructor("Anthony", "Taylor", 15, "Principal Developer"
                , "M", true, asList(JAVA_PROGRAMMING, "Angular Programming", REACT_NATIVE, "Spring Reactive Programming", SPRING_BOOT_2_RECIPES, "Microservices using Docker", "AWS Lambda", "Serverless Development"));

        Instructor instructor5 = new Instructor("Syed", "Ahmed", 15, "Principal Engineer"
                , "M", true, asList(JAVA_PROGRAMMING, "Java Multi-Threaded Programming", REACT_NATIVE));

        Instructor instructor6 = new Instructor("Steve", "Hanson", 10, "Lead Software Engineer"
                , "M", true, asList(JAVA_PROGRAMMING, SPRING_BOOT_2_RECIPES, WEB_PROGRAMMING, "Docker & Kubernetes", "Modern javascript", "Vue Development"));

        Instructor instructor7 = new Instructor("Patrick", "Morrison", 8, "Principal Engineer"
                , "M", false, asList(WEB_PROGRAMMING, "Spring 5 Programming", REACT_NATIVE, "Redux State Management", "Full Stack Development", "DevOps and Beyond", "Cloud Native Development", "Serverless Development using AWS"));

        Instructor instructor8 = new Instructor("Mike", "Peterson", 8, "Staff Software Engineer"
                , "M", true, asList(JAVA_PROGRAMMING, "Ruby Programming", "Python Programming", SPRING_BOOT_2_RECIPES,
                WEB_PROGRAMMING, "Docker DevOps", "Ruby in Action"));

        return asList(instructor1, instructor2, instructor3, instructor4, instructor5, instructor6, instructor7, instructor8);

    }
}
