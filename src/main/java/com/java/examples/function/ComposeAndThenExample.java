package com.java.examples.function;

import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComposeAndThenExample {
    private static Logger logger = Logger.getLogger(ComposeAndThenExample.class.getName());
    public static void main(String[] args) {
        Function<Integer, Integer> add = v -> v + 3;
        Function<Integer, Integer> multiply = v -> v * 2;

        // AndThen applies function first, then applies parameters
        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);
        Integer result = multiplyThenAdd.apply(3);
        logger.log(Level.INFO,"Result multiplyThenAdd: {0}", result);

        // Compose applies parameters first and then calls function
        Function<Integer,Integer> multiplyComposeAdd = multiply.compose(add);
        result = multiplyComposeAdd.apply(3);
        logger.log(Level.INFO,"Result multiplyComposeAdd : {0}", result);
    }

}
