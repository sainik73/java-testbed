package com.java.examples.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.IntStream;

/**
 * @author Kiran
 * @since 5/3/2021
 */
public class TestArrayInSortedOrder {
    @Test
    public void givenArray_whenSorted_thenReturnTrue() {
        int[] A = IntStream.rangeClosed(1, 10).toArray();
        assertEquals(1,isArrayInSortedOrder(A, A.length));
    }

    @Test
    public void givenArray_whenUnsorted_thenReturnFalse() {
        int[] A = new int[]{0,1,2,4,3,5};

        assertEquals(0,isArrayInSortedOrder(A, A.length));
    }

    /**
     * Algorithm to test if the given input array is sorted or not
     * Logic is to test last 2 items -> if 0, then move to next iteration
     * last step is return 1, if index=1. if recursion fails anytime will return 0.
     * @param A     int array
     * @param index length of array or last index
     * @return int
     */
    public static int isArrayInSortedOrder(int[]A, int index){
        if(index ==1)
            return 1;

        return A[index-1] < A[index-2]?0:isArrayInSortedOrder(A,index-1);

    }
}
