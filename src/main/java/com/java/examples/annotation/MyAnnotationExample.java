package com.java.examples.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyAnnotationExample {

    @MyAnnotation(priority = MyAnnotation.Priority.HIGH, key = @Key(name = "greetMe", value = "Hello Kiran"))
    public void greetMe() {
    }

    @MyAnnotation(key = @Key(name = "greetMe", value = "Hello World"))
    public void greetWorld() {
    }

    @MyAnnotation(key = @Key())
    public void greet() {
    }

    public static void main(String[] args) {
        MyAnnotationExample my = new MyAnnotationExample();
        Method[] methods = MyAnnotationExample.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                if (annotation.priority().equals(MyAnnotation.Priority.HIGH) &&
                        annotation.key().name().equals("greetMe")) {
                    System.out.println("Running Java method annotations with custom key value:: " + annotation.key().value());
                } else if (annotation.priority().equals(MyAnnotation.Priority.MEDIUM) &&
                        annotation.key().name().equals("greetMe")) {
                    System.out.println("Running Java method annotations with default key value:: " + annotation.key().value());
                } else System.out.println("Running with no annotations: Hello....");
            }
        }
    }
}
