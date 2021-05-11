package com.java.examples.datastructure;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * Example1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *  Example2:
 *  Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * The overall run time complexity should be O(log (m+n))
 */
public class TestMedianOfSortedArray {
    public static void main(String[] args) {
        TestMedianOfSortedArray test = new TestMedianOfSortedArray();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{0,2,3};
        System.out.println("Result :"+ test.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        int[] merged = new int[0];
        boolean isMerged = false;
        if(nums1.length == 0){
            merged = nums2;
            isMerged = true;
        }
        if (nums2.length == 0){
            merged = nums1;
            isMerged = true;
        }
        if(!isMerged) {
            merged = new int[nums1.length + nums2.length];
            int mergedCounter = 0;
            for (int j : nums1) {
                merged[mergedCounter++] = j;
            }
            for (int j : nums2) {
                merged[mergedCounter++] = j;
            }
        }
        //sort array
        int tmp;
        for(int i=0; i< merged.length-1; i++){
            for(int j=i+1; j< merged.length; j++){
                if(merged[i] > merged[j]){
                    tmp = merged[i];
                    merged[i] = merged[j];
                    merged[j] = tmp;
                }
            }

        }
        //Arrays.stream(merged).forEach(x->System.out.println(x));
        // check length- even or odd
        if(merged.length%2 ==0){
            System.out.println("median element: "+ merged[(merged.length/2)]);
            median = Double.valueOf (merged[(merged.length/2) -1] + merged[merged.length/2])/2;
        }else{

            median = merged[merged.length/2];
        }
        return median;

    }
}
