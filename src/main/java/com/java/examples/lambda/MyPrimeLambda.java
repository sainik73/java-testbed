package com.java.examples.lambda;

public class MyPrimeLambda implements PrimeLambda {

    public static void main(String[] args) {
        MyPrimeLambda my = new MyPrimeLambda();
        int valueToTest = 6;
        System.out.println(valueToTest + " isPrime? : " + my.checkPrime(valueToTest));

        valueToTest = 9;
        System.out.println(valueToTest + " isPrime? : " + my.checkPrime(valueToTest));

        valueToTest = 61;
        System.out.println(valueToTest + " isPrime? : " + my.checkPrime(valueToTest));
    }

    public boolean checkPrime(int n) {
        PrimeLambda p = new PrimeLambda() {
            @Override
            public boolean checkPrime(int y) {
                int x = 2;
                boolean isPrime = true;
                if (y == 1) isPrime = false;
                while (x < y) {
                    if (y % x == 0) {
                        isPrime = false;
                        break;
                    }
                    x++;
                }
                return isPrime;
            }
        };

        return p.checkPrime(n);
    }
}
