package com.java.examples.streams;

import com.java.examples.function.Instructor;
import com.java.examples.function.Instructors;

import java.util.Comparator;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class TestStreamsTemporary {
    public static void main(String[] args) {
        //print the list of instructor names in descending order
        out.println("***** All instructor by first name (descending), followed by years of experience " +
                "(descending) ->");
        Instructors.getAll().stream().
                sorted(Comparator.comparing(Instructor::getFirstName).reversed().thenComparing(Instructor::getYearsOfExperience).reversed())
                .collect(Collectors.toList())
                .forEach(i -> out.println(i.getFirstName() + "," + i.getLastName() + " [" + i.getYearsOfExperience() +
                        "]"));


        //print the list of instructor names grouped by years of exp
        out.println();
        out.println("***** instructors grouped by years of exp ->");
        out.println(Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(instructor -> instructor.getFirstName() + " " + instructor.getLastName(),
                                Collectors.toList()))));

        //print all instructors based on years of experience in descending order
        out.println();
        out.println("****** instructors based on years of experience in descending order -> ");
        out.println(Instructors.getAll().stream()
                .sorted(Comparator.comparing(Instructor::getYearsOfExperience).reversed())
                .map(i -> new CustomInstructor(i.getFirstName(), i.getLastName(), i.getYearsOfExperience()))
                .collect(Collectors.toList()));

        //print the list of instructors names grouped by online course
        out.println();
        out.println("***** instructors grouped by learning mode ->");
        out.println(Instructors.getAll().stream()
                .collect(Collectors.groupingBy(instructor ->
                                instructor.isOnlineCourses() ? "Online" : "Classroom",
                        Collectors.mapping(instructor -> instructor.getFirstName() + " " + instructor.getLastName(),
                                Collectors.toList()))));


        out.println();
        out.println("***** Most experienced instructor grouped by learning mode ->");

        //all unique courses offered
        out.println();
        out.println("**** Total Unique Courses offered -> ");

        out.println("**** List All courses offered by instructors -> ");

        //which courses are offered online versus classroom
        out.println("**** Total Courses offered by learning mode -> ");

        out.println("**** Learning mode and courses offered -> ");

        out.println("**** Courses offered common across Classroom and Online Learning mode -> ");


    }

    static class CustomInstructor {
        private String firstName, lastName;
        private int experience;

        CustomInstructor(String first, String last, int exp) {
            firstName = first;
            lastName = last;
            experience = exp;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        @Override
        public String toString() {
            return "CustomInstructor{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", experience=" + experience +
                    '}';
        }
    }
}
