package com.java.examples.test;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Java Bitwise operators
 * https://refreshjava.com/java/bitwise-operators
 * << - Left shifts the bits of a by 2 position (negative number can become a positive number and vice-versa)
 * >> - Signed Right shifts the bits of a by 2 position ( if last MSB is 0, it's a positive number and stays positive.
 * Right shift the number by 2 zeros.
 * if last MSB is 1, Right shift the number by 2 ones. it's a negative number and stays negative
 * >>> - Right shifts the bits of a by 2 position (and places 0's in left side. It always returns a positive number.)
 */
public class TestBitwiseOperator {

    /**
     * 2s complement working:
     * 0001 0011 (positive 19)
     * 1110 1100 (invert bits)
     * 1110 1101 (add 1)
     * 1110 1101 (-19 in binary)
     */
    @Test
    public void testBitwise() {
        int nineteen = 0B00010011;
        int minusNineteen = -0B00010011;
        assertEquals(19, nineteen);
        assertEquals(-19, minusNineteen);
        System.out.println(Integer.toBinaryString(19));
        System.out.println(Integer.toBinaryString(-19));

    }

    /**
     * Arithmetic Right shift preserves the most significant bit (msb).
     * Below example,the original msb is 0, and we fill in the ?? with 0
     * 19         = |{0=msb}001 0011|
     * >> 2
     * 19 >> 2    = |??00 0100|11
     * 19 >> 2    = |0000 0100|11 (fill with msb) Answer is 4
     * <p>
     * Example 2:
     * -19        = |{1=msb}110 1101|
     * >> 2
     * -19 >> 2   = |??11 1011|01
     * -19 >> 2   = |1111 1011|01 (fill with msb) Answer is -5
     * <p>
     * Java uses two's complement for negative numbers and the basic rule is to take the positive, invert all bits
     * then add one. That gets you the negative.
     * 5         = 0000 0101
     * 1111 1010 (invert all digits)
     * 1111 1011 (add 1) Answer is -5
     * two's complement for positive numbers:
     * -5        = 1111 1011
     * 0000 0100 (invert all digits)
     * 0000 0101 (add 1) Answer is 5
     */
    @Test
    public void testArithmeticRightShiftOperator() {
        int nineteen = 19;
        assertEquals(4, nineteen >> 2);

        int minusNineteen = -19;
        assertEquals(-5, minusNineteen >> 2);
    }

    /**
     * Java uses two's complement for negative numbers and the basic rule is to take the positive, invert all bits
     * then add one. That gets you the negative.
     */
    @Test
    public void testConvertPositiveNumberToNegativeEquivalent() {
        int nineteen = 19;
        int minusNineteen = -19;
        int i = ~nineteen;//invert all digits
        i = i + 1; //add 1
        assertEquals(minusNineteen, i);
    }
}
