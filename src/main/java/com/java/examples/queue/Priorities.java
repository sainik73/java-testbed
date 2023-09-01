package com.java.examples.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.
 * <p>
 * ENTER: A student with some priority enters the queue to be served.
 * SERVED: The student with the highest priority is served (removed) from the queue.
 * A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):
 * <p>
 * The student having the highest Cumulative Grade Point Average (CGPA) is served first.
 * Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
 * Any students having the same CGPA and name will be served in ascending order of the id.
 */
public class Priorities {

    public List<Student> getStudents(List<String> events) {
        List<Student> students = new ArrayList<>(events.size());
        for (String event : events) {
            if (event.contains("ENTER")) {
                //add student
                String[] str = event.split(" ");
                students.add(new Student(Integer.parseInt(str[3]),
                        str[1], Double.parseDouble(str[2])));
            } else if (event.contains("SERVED")) {
                //remove student

                //display("before", students);
                Collections.sort(students, new StudentComparator());
                //display("after", students);
                if (!students.isEmpty())
                    students.remove(0);
            }
        }
        return students;

    }

    void display(String label, List<Student> students) {
        System.out.println("*** " + label + " Display *** ");
        for (Student st : students) {
            System.out.println(st.getName());
        }
        System.out.println("*** " + label + " End Display *** ");
    }

    class StudentComparator implements Comparator {
        @Override
        public int compare(Object a, Object b) {
            //descending CGPA priority
            int compare = Double.compare(((Student) b).getCGPA(), ((Student) a).getCGPA());
            //ascending name priority
            if (compare == 0) {
                compare = ((Student) a).getName().compareTo(((Student) b).getName());
                //ascending Id priority
                if (compare == 0) {
                    compare = Integer.compare(((Student) a).getId(), ((Student) b).getId());
                }
            }
            return compare;
        }
    }


}// End Priorities
