package com.java.examples.function;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstructorConsumerExample {
    public static final Logger logger = Logger.getLogger(InstructorConsumerExample.class.getName());
    private static final String SPACER = "--------------------------------------------";

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        //looping through all the instructor and printing out the values of instructor
        Consumer<Instructor> c1 = v -> logger.log(Level.INFO, "{0}", v);
        instructors.forEach(c1);
        logger.log(Level.INFO, SPACER);

        //Loop through all the instructor and only print out their name
        Consumer<Instructor> c2 = v -> logger.log(Level.INFO, "{0}", v.getName());
        instructors.forEach(c2);
        logger.log(Level.INFO, SPACER);

        //Loop through all the instructors and print out their names and their courses
        Consumer<Instructor> c3 = v -> logger.log(Level.INFO, "{0}", v.getCourses());
        instructors.forEach(c2.andThen(c3));
        logger.log(Level.INFO, SPACER);

        //Loop through all the instructors and print out their name if the years of experience is >10
        instructors.forEach(v -> {
            if (v.getYearsOfExperience() > 10) {
                c2.accept(v);
            }
        });


    }
}
