package com.java.examples.test;

/**
 * Purpose of this class is to find the max difference in 2 adjacent numbers
 * e.g. in a list of 10,2,20,40,3,100,50 -> the correct numbers are 3,100
 */
public class FindAdjacentGap {
    public static void main(String[] args) {
        int[] arr = new int []{10,2,20,40,3,100,50};

        int lengthOfArray = arr.length;
        System.out.println("Count of numbers to compare are: " + lengthOfArray);
        int i = arr[0];
        int j = arr[1];
        int difference = Math.abs(i-j);//initial difference to compare against
        int newdifference;
        if (lengthOfArray > 2) { //only do the comparison if there are more than 2 elements in array
            for (int l = 0; l < arr.length - 1; l++) {
                newdifference = Math.abs(arr[l] - arr[l + 1]);
                if (newdifference > difference) {
                    i = arr[l];
                    j = arr[l + 1];
                    difference = newdifference;
                }
            }
            System.out.println(" The numbers are " + i + " : " + j + ", and the difference is " + difference);
        }
        System.out.println("----END----");


    }
}
