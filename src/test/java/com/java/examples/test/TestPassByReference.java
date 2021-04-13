package com.java.examples.test;

public class TestPassByReference {


    int[] changeInts(int[] intArray){
        intArray[0] = 9;

        return intArray;
    }
    public static void main(String[] args) {
        int[] ints = new int[]{0,1,2,3};
        TestPassByReference test = new TestPassByReference();
        int[] newInts = test.changeInts(ints);

        System.out.println("check first element: " + ints[0]);
        System.out.println("check modified first element: "+ newInts[0]);
        if(ints[0] == newInts[0]){
            System.out.println("Arrays are passed by reference");
        }else{
            System.out.println("Arrays are passed by value");
        }
    }
}
