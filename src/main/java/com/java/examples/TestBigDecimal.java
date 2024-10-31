package com.java.examples;

import java.util.Optional;

public class TestBigDecimal {
    public static void main(String[] args) {
        Double dNetPrice = 7.6;
        Double newNetPrice = Optional.ofNullable(dNetPrice).orElse(0.0);
        System.out.println("double value: " + newNetPrice);
    }

}
