package com.java.examples.datastructure;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This class will arrange the array into ascending order
 * Input  : 1 1 2 0 0 3 1
 * Output : 0 0 1 1 1 2 3
 * @author sainik73
 *
 */
public class SortAlgo {
    private static Logger logger = Logger.getLogger(SortAlgo.class.getName());

    public static void main(String[] args) throws Exception {

        /** BUBBLE SORT **/
        int sizeOfArray = 10000;
        int[] tleArray = new int[sizeOfArray];//{34,9,2,65,23,87,54,33,56,55,76,3,35,65,83,26,11,46,38,99,22,41,40,99,88,44,55,83,45,60,73,35,67,89};
        Random rand = new Random();
        for (int iCounter=0; iCounter< tleArray.length;iCounter++ ) {
            tleArray[iCounter]= rand.nextInt(sizeOfArray); //(int)(Math.random()*sizeOfArray);
        }


        /*Faster implementation of Bubble Sort*/
        int[] arr = Arrays.copyOf(tleArray, tleArray.length);
        bubbleSort(arr);

        /*Slower implementation of Bubble Sort*/
        int[] arr1 = Arrays.copyOf(tleArray, tleArray.length);
        bubbleSort1(arr1);

        /* Selection Sort */
        int[] arr2 = Arrays.copyOf(tleArray, tleArray.length);
        selectionSort(arr2);

        int[] arr3 = Arrays.copyOf(tleArray, tleArray.length);
        long startTimeNew = System.currentTimeMillis();
        //quickSort(arr3);
        quickSort(arr3, 0, arr3.length-1);
        long endTimeNew = System.currentTimeMillis();
        logger.info(" Took " + (endTimeNew- startTimeNew) + " ms  to do quick Sort - Array with length: " + arr3.length);
        logger.info("TLE Ascending using Java Quick Sort:: " + printArray(arr3));



    }


    /*
     * Method implementing the bubble sort algorithm
     * Simplest Algo but works for small dataset which is already sorted and out of sort is very less elements. Not efficient for large datasets.
     */
    private static void bubbleSort(int arr[])
    {
        long startTime = System.currentTimeMillis();
        int loopCounter=0;
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            loopCounter=i;
        }
        long endTime = System.currentTimeMillis();
        logger.info(" Took " + (endTime- startTime) + " ms with " + loopCounter + " Loops to bubble Sort Array with length: " + n);
        logger.info(()->"TLE Ascending using Java Custom sort - bubbleSort:: " + printArray(arr));
    }

    /***** Modified Method implementing the bubble sort algorithm *****/
    private static int[] bubbleSort1(int[] tleArray){
        int n = tleArray.length;
        //logger.info("length::" + length);
        int loopCounter=0;
        long startTime = System.currentTimeMillis();
        // An optimized version of Bubble Sort
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            loopCounter++;
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (tleArray[j] > tleArray[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = tleArray[j];
                    tleArray[j] = tleArray[j + 1];
                    tleArray[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

        long endTime = System.currentTimeMillis();
        logger.info(" Took " + (endTime- startTime) + " ms with " + loopCounter + " Loops to bubble Sort Array with length: " + n);
        logger.info("TLE Ascending using Java Custom Sort- bubbleSort1:: " + printArray(tleArray));
        return tleArray;
    }

    /*
     * Selection Sort
     * The selection sort algorithm is an in-place sort which sorts an array by repeatedly finding the minimum element
     * (considering ascending order) from unsorted part and putting it at the beginning.
     * Time Complexity: O(n^2)
     */
    private static void selectionSort(int[] tleArray){
        long startTime = System.currentTimeMillis();
        int temp = 0;
        int index = 0;
        int length = tleArray.length;
        int loopCounter = 0;
        for (int i=0;i<length-1;i++){
            temp = tleArray[i];
            loopCounter++;
            for (int j=i+1;j<length;j++){
                if( temp> tleArray[j]){
                    temp = tleArray[j];
                    index = j;
                }
            }
            //swap the lowest number
            if(index !=0){
                tleArray[index] = tleArray[i];
                tleArray[i] = temp;
                index = 0;//reset
            }
        }
        long endTime = System.currentTimeMillis();
        logger.info(" Took " + (endTime- startTime) + " ms  with " + loopCounter + " loops to do selection Sort - Array with length: " + length);
        logger.info("TLE Ascending using Java Custom Sort - selectionSort:: " + printArray(tleArray));
    }

    /*
     * Quick Sort
     * This is the fastest algo
     */
    private static void quickSort(int[] tleArray){
        long startTime = System.currentTimeMillis();
        int length = tleArray.length;
        int pivot = tleArray[length-1];
        logger.info(() -> "Pivot: " + pivot);
        //int pivotVal = tleArray[pivot];
        int iCounter =0;
        boolean swap = false;

        for(int i: tleArray){

            if(i>pivot){
                //swap
                tleArray[iCounter]= pivot;
                tleArray[length-1] = i;
                //quickSort(tleArray);
            }else{

            }
            iCounter++;
        }
        long endTime = System.currentTimeMillis();
        logger.info(" Took " + (endTime- startTime) + " ms with " + iCounter + " loops to do quick Sort - Array with length: " + length);
        logger.info("TLE Ascending using Java Quick Sort:: " + printArray(tleArray));
    }

    /**
     * QuickSort is the fastest algo.The main function that implements QuickSort()
     * arr[] --> Array to be sorted,
     * low  --> Starting index,
     * high  --> Ending index
     */
    private static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
         /* pi is partitioning index, arr[pi] is
           now at right place */
            int pi = partition(arr, low, high);
            //logger.info("PI: "+pi + " low:"+ low + " high:"+ high);
            // Recursively sort elements before
            quickSort(arr, low, pi-1);

            // partition and after partition
            quickSort(arr, pi+1, high);
        }

    }

    /**
     *  This function takes last element as pivot,
     *  places the pivot element at its correct
     *  position in sorted array, and places all
     *  smaller (smaller than pivot) to left of
     *  pivot and all greater elements to right of pivot
     */
    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    //PrintArray
    private static String printArray(int[] tleArray) {
        StringBuilder toPrint = new StringBuilder();
        int iCounter=0;
        for (int i: tleArray){
            toPrint.append(i);
            iCounter++;
            if(iCounter != tleArray.length){
                toPrint.append(",");
            }
        }
        return toPrint.toString();
    }


    //inner class
    public class Pair{
        int element = 0;
        int index = 0;
        public Pair(int element, int index){
            this.element = element;
            this.index = index;

        }
        public int getElement() {
            return element;
        }
        public void setElement(int element) {
            this.element = element;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Pair: " + this.element + " :: " + this.index;
        }
    }

}

