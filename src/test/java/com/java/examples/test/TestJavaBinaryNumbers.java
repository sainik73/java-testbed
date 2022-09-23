package com.java.examples.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Java 7 introduced binary literals. This is a test class for converting byte to decimal representation and vice
 * versa
 */
public class TestJavaBinaryNumbers {

    /**
     * Java 7 introduced the binary literal.     *
     * To use it, we need to prefix the number with 0B or 0b
     */
    @Test
    public void givenABinaryLiteral_thenReturnTheDecimalValue() {

        byte five = 0b101;
        assertEquals((byte) 5, five);

        short three = 0b11;
        assertEquals((short) 3, three);

        int nine = 0B1001;
        assertEquals(9, nine);

        long twentyNine = 0B11101;
        assertEquals(29, twentyNine);

        int minusThirtySeven = -0B100101;
        assertEquals(-37, minusThirtySeven);
        System.out.println("binary string: " + Integer.toBinaryString(minusThirtySeven));
    }

    /**
     * convert a Decimal number to binary number
     */
    @Test
    public void givenADecimalNumber_thenConvertToBinaryNumber() {
        assertEquals("101", Integer.toBinaryString(5));
        assertEquals("10100", Integer.toBinaryString(20));
    }

    /**
     * Convert Binary to Decimal using parseInt function:
     * It takes two parameters as input:
     * - Binary string to be converted
     * - Radix or base of the number system in which input string has to be converted
     */
    @Test
    public void givenABinaryNumber_thenConvertToDecimalNumber() {
        assertEquals(8, Integer.parseInt("1000", 2));
        assertEquals(20, Integer.parseInt("10100", 2));
    }
}
