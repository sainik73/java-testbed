package com.java.examples.lambda;

/**
 * This class is a working example of lambda expression without type inference.
 */
public class MyLambdaGreeter {

    public static void main(String[] args) {
        System.out.println("Greeting using lambda expressions:");
        Greeter greeter = (String s)-> "Hello ... greetings from " + s;
        System.out.println(greeter.greet("lambda"));
    }
}
