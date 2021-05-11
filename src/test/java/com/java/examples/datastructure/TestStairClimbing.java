package com.java.examples.datastructure;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *Constraints: *
 * 1 <= n <= 45
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class TestStairClimbing {
    public static void main(String[] args) {
        int stairCount = 7;
        TestStairClimbing test = new TestStairClimbing();
        System.out.println(test.climbStairs(stairCount));
    }
    public int climbStairs(int n) {
        if(n>=1 && n<=45) {
            int[] ways = new int[n + 2];
            ways[1] = 1;
            ways[2] = 2;
            for (int i = 3; i <= n; i++) {
                ways[i] = ways[i - 1] + ways[i - 2];
            }

            return ways[n];
        }
        return 0;

    }
}
