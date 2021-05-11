package com.java.examples.datastructure;

import java.util.Arrays;
import java.util.Random;

/**
 * This class can search KOrder statistics using Quick Select algo
 * e.g smallest item or 2nd smallest item in an array {or}
 * largest item or 2nd largest item in an array
 * It has two phases - partition and select
 *
 * Time and Space complexity: O(log n)
 */
public class KOrderStatistic {
    private int[] nums;
    private int firstIndex;
    private int lastIndex;
    private boolean order = true;//default. Values: Smallest -> true, Largest -> false

     public KOrderStatistic(int[] nums){
        this.nums = nums;
        firstIndex = 0;
        lastIndex = nums.length -1;
    }
    //Values of KOrder: Smallest -> true, Largest -> false
    public int select(String KOrder, int k){
        order = "SMALLEST".equalsIgnoreCase(KOrder);
         return select(firstIndex,lastIndex,k);
    }

    private int select (int firstIndex, int lastIndex, int k){
        int pivot = partition(firstIndex, lastIndex);
        if(pivot > k){
            return select(firstIndex,pivot-1,k);
        }else if(pivot < k){
            return select(pivot+1,lastIndex,k);
        }

        return nums[k];
    }

    /**
     * This method will identify a random pivot and swap all elements such as left side of pivot
     * has smaller value elements and right side has larger value than pivot.
     * @param firstIndex    starting index of the datastructure
     * @param lastIndex     last index of the datastructure
     * @return pivot index
     */
    private int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex-firstIndex+1) +firstIndex;
        swap(pivot,lastIndex);
        if(order) {
            for (int i = firstIndex; i <= lastIndex; i++) {
                if (nums[i] < nums[lastIndex]) {
                    swap(i, firstIndex);
                    firstIndex++;
                }
            }
        }
        else{
            for(int i=firstIndex; i<=lastIndex; i++){
                if(nums[i]>nums[lastIndex]){
                    swap(i,firstIndex);
                    firstIndex++;
                }
            }
        }
        swap(lastIndex,firstIndex);

        Arrays.stream(nums).forEach(i-> System.out.print(i + ", "));
        System.out.println("------------ Pivot : " + nums[firstIndex]);
        //this is the pivot
        return firstIndex;
    }

    private void swap(int pivot, int lastIndex) {
         int tmp = nums[lastIndex];
         nums[lastIndex] = nums[pivot];
         nums[pivot] = tmp;
    }

    public static void main(String[] args) {
        int[] nums= {-1,2,3,6,-4,5,22,4,35,11,33,-15,44,55,67,78,30,12,23,34,41,40,39,-3,49,100};
        KOrderStatistic kOrderStatistic = new KOrderStatistic(nums);
        System.out.println("Second Smallest Value: "+ kOrderStatistic.select("Smallest",1));//select 2nd smallest; smallest is 0 index
        System.out.println("Largest Value: "+ kOrderStatistic.select("Largest",0));
    }
}
