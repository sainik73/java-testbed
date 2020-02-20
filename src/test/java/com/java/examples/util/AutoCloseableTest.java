package com.java.examples.util;

/**
 * Custom Java class implementing try-with-resources
 * Refer:: http://tutorials.jenkov.com/java-exception-handling/try-with-resources.html
 *
 */
public class AutoCloseableTest  implements AutoCloseable{

    private static void myAutoClosable() throws Exception {
        //try-with-resources
        try(AutoCloseableTest myAutoClosable = new AutoCloseableTest()){
            myAutoClosable.doIt();
        }
    }

    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }

    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");

    }

    //main method to test auto closing of resource
    public static void main(String[] args) throws Exception {
        AutoCloseableTest.myAutoClosable();
    }

}
