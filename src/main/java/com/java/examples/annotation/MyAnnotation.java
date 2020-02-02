package com.java.examples.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation{

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Priority priority() default Priority.MEDIUM;
    public Key key();
}
