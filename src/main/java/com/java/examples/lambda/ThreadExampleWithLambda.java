package com.java.examples.lambda;

/**
 * This class is a working example of implementing existing classes/libraries
 * with legacy code (prior to Jav 8) and lambda expression
 */
public class ThreadExampleWithLambda {
    public static void main(String[] args) {
        Thread myNormalThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Java 7: Running a thread with Runnable.");
            }
        });

        myNormalThread.run();

        Thread myLambdaThread = new Thread(() -> System.out.println("Java 8: Running thread with lambda expression"));
        myLambdaThread.run();
    }
}
