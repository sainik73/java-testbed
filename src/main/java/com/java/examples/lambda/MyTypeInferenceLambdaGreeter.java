package com.java.examples.lambda;

/**
 * This class is a working example of lambda expression with type inference.
 * You don't have to specify any types in lambda expression and java compiler
 * can make inference form the functional interface.
 */
public class MyTypeInferenceLambdaGreeter {
    public static void main(String[] args) {
        System.out.println("Greeting using lambda expressions with type inference:");
        Greeter greeter = s -> "Hello ... greetings from " + s;
        System.out.println(greeter.greet("lambda"));
    }

}
