package com.java.examples.function;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

//@see java.util.function.Function Interface
public class ComposeAndThenExample {
    private static final Logger logger = Logger.getLogger(ComposeAndThenExample.class.getName());
    private static final String SPACER = "------------------------------------";

    public static void main(String[] args) {
        Function<Integer, Integer> add = v -> v + 3;
        Function<Integer, Integer> multiply = v -> v * 2;

        Function<Integer, String> addAndReturnStringOutput = v -> ("Output is " +v + 3);

        // AndThen applies function first, then applies parameters
        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);
        Integer result = multiplyThenAdd.apply(3);
        logger.log(Level.INFO,"Result multiplyThenAdd: {0}", result);

        logger.log(Level.INFO,SPACER);
        // Compose applies parameters first and then calls function
        Function<Integer,Integer> multiplyComposeAdd = multiply.compose(add);
        result = multiplyComposeAdd.apply(3);
        logger.log(Level.INFO,"Result multiplyComposeAdd : {0}", result);

        logger.log(Level.INFO,SPACER);
        logger.log(Level.INFO, "Result Function<Integer, String> : {0}", addAndReturnStringOutput.apply(3));

        logger.log(Level.INFO,SPACER);
        IntFunction<Double> ob = a -> a / 2.0;
        // Using apply() method
        logger.log(Level.INFO,"Result IntFunction : {0}",ob.apply(3));

    }

}
