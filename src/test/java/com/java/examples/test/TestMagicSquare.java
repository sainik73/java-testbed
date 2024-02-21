package com.java.examples.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This method works for odd size squares to create magic square.
 * Magic square is a square whose rows, columns and diagonals have same sum count.
 * Logic: Start in first row and middle column.
 * Decrement the row and increase column. Wrap the values if required.
 * if the cell is already filled, increment the row.
 */
public class TestMagicSquare {
    static int size = 5;
    static int[][] magicSquare = new int[size][size];

    @BeforeAll
    static void createMagicSquare() {
        int row = 0;
        int col = (size - 1) / 2;
        int fillCount = size * size;
        // magicSquare[row][col] = 1;
        for (int i = 1; i <= fillCount; i++) {
            System.out.println("row: " + row + " : col: " + col);
            magicSquare[row][col] = i;
            //decrement and wrap row, if needed
            int nextRow = row - 1;
            if (nextRow < 0) {
                nextRow = size - 1;
            }
            //increment and wrap column, if needed
            int nextCol = col + 1;
            if (nextCol >= size) {
                nextCol = 0;
            }

            if (magicSquare[nextRow][nextCol] != 0) {
                nextRow = row + 1;
                nextCol = col;
            }

            row = nextRow;
            col = nextCol;

        }
        //print the magic square
        for (int[] rowP : magicSquare) {
            System.out.println(Arrays.toString(rowP));
        }
    }

    @Test
    void testColumnCount() {
        AtomicInteger sum = new AtomicInteger();
        int expectedValue = ((size * size * size) + size) / 2;
        IntStream.range(0, size).forEach(y -> {
            sum.set(IntStream.range(0, size).map(x -> magicSquare[x][y]).sum());
            assertEquals(expectedValue, sum.get());
        });
    }

    @Test
    void testRowCount() {
        AtomicInteger sum = new AtomicInteger();
        int expectedValue = ((size * size * size) + size) / 2;
        IntStream.range(0, size).forEach(x -> {
            sum.set(Arrays.stream(magicSquare[x], 0, size).sum());
            assertEquals(expectedValue, sum.get());
        });
    }

    @Test
    void testDiagonalCount() {
        int expectedValue = ((size * size * size) + size) / 2;
        int sum = IntStream.range(0, size).map(i -> magicSquare[i][i]).sum();
        assertEquals(expectedValue, sum);
        //other diagonal
        sum = IntStream.range(0, size).map(i -> magicSquare[i][size - i - 1]).sum();
        assertEquals(expectedValue, sum);
    }
}
