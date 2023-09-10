package com.java.examples.datastructure;

import java.util.*;

/**
 * In this problem, you are given  integers.
 * You need to find the maximum number of unique integers among all the possible contiguous subarrays of size M.
 * Input Format
 * <p>
 * The first line of input contains two integers N and M: representing the total number of integers and the size of the
 * subarray, respectively. The next line contains  space separated integers.
 * <p>
 * Output Format
 * <p>
 * Print the maximum number of unique integers among all possible contiguous subarrays of size M.
 * <p>
 * Sample Input
 * 6 3
 * 5 3 5 2 3 2
 * <p>
 * Sample Output
 * 3
 * <p>
 * Explanation:
 * In the sample testcase, there are 4 subarrays of contiguous numbers.
 * <p>
 * s1 - {5,3,5} - Has 2 unique numbers.
 * <p>
 * s1 - {3,5,2} - Has 3 unique numbers.
 * <p>
 * s1 - {5,2,3} - Has 3 unique numbers.
 * <p>
 * s1 - {2,3,2} - Has 2 unique numbers.
 * <p>
 * In these subarrays, there are {2,3,3,2} unique numbers, respectively.
 * The maximum amount of unique numbers among all possible contiguous subarrays is 3.
 */
public class TestSubArraysWithUniqueNumbers {

    public static void main(String[] args) {
        System.out.println("Please enter input: ");
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] numArray = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            numArray[i] = num;
            deque.add(num);
        }

        getMaximumUniqueElementsInAllSubArrays(n, m, numArray);
    }

    static void getMaximumUniqueElementsInAllSubArrays(int n, int m, Deque deque) {
        //deque.stream().map(o -> {})
    }

    static void getMaximumUniqueElementsInAllSubArrays(int n, int m, int[] numArray) {

        int totalSubArrays = n - m + 1;
        int max = 0;//max number of unique numbers in a sub array
        //get unique numbers
        Set<Integer> sSet = new HashSet<>();
        int startIndex = 0;
        //iterate through sub arrays
        for (int x = 0; x < totalSubArrays; x++) {
            for (int y = startIndex; y < startIndex + m; y++) {
                sSet.add(numArray[y]);
            }
            if (sSet.size() > max) {
                max = sSet.size(); // store the new max size
                System.out.println("max: " + max);
                if (max == m) {
                    //we hit the maximum number of unique numbers
                    break;
                }
            }
            //increment start index
            startIndex++;
            sSet.clear();

        }
        System.out.println(max);

    }


}
