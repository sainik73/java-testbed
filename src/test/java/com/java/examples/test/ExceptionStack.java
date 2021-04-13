package com.java.examples.test;

import java.io.IOException;

/**
 * output should be:
 * >>>> Third
 * >>>First
 * >>>> Second
 * >>>> Fifth
 * >>>> Sixth
 */
public class ExceptionStack {
    public static void main(String[] args) throws IOException {
        methodA();
        System.out.println(">>>> Sixth");
    }

    private static void methodA() throws IOException {
        methodB();
        System.out.println(">>>> Fifth");
    }

    private static void methodB() throws IOException {
        try {
            System.out.println(">>>> Third");
            methodC();
            throw new IOException();
        }catch (IOException e){
            System.out.println(">>>> Fourth");
            throw new IOException();
        }catch(RuntimeException e){
            System.out.println(">>>> Second");
        }
    }

    private static void methodC() {
        System.out.println(">>>First");
        throw new RuntimeException("test");
    }
}
