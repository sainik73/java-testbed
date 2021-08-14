package com.java.examples.test;

/**
 * Problem: pond having single bacterium which doubles every 5 min and fills pond in 24 hours.
 * If pond is started with 2 bacterium, how long will it take to fill the pond
 */
public class TestGrowthAlgo {
    public static void main(String[] args) {
        int time = calculateFillTime(5);
        System.out.println("Time to fill: " + time + " minutes.");
    }

    private static int calculateFillTime(int startingCount) {
        final int totalIncrementCycles = (24*60)/5; //tank fills in 24 hours
        final double maxCapacity =  Math.pow(2,totalIncrementCycles);
        //System.out.println("total increment: "+ totalIncrementCycles + ", max capacity: "+ maxCapacity);

        double capacity =0;
        int incrementCount = 0;
        while (capacity <maxCapacity){
            capacity = (Math.pow(2,incrementCount++))*startingCount;
            //System.out.println("Starting count: "+ incrementCount +" , Capacity: " + capacity);
        }

        return (incrementCount -1)*5;
    }
}
