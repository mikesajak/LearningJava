package org.mikesajak.javaschool.lesson01;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleDecNumberTest {

    @Test
    public void ofInt() {
        SimpleDecNumber num = SimpleDecNumber.of(1);

        int[] numRep = num.representation();
        assertEquals(10, numRep.length);
        assertArrayEquals("", new int[] {1,0,0,0,0,0,0,0,0,0}, numRep);
    }

    @Test
    public void ofIntTooBig() {
        try {
            SimpleDecNumber num = SimpleDecNumber.of(10);
            fail("Expected exception for illegal number (too big, only <10 values are allowed");
        } catch (IllegalArgumentException ex) {
            // ignored
        }

        try {
            SimpleDecNumber num = SimpleDecNumber.of(100);
            fail("Expected exception for illegal number (too big, only <10 values are allowed");
        } catch (IllegalArgumentException ex) {
            // ignored
        }

        try {
            SimpleDecNumber num = SimpleDecNumber.of(10000);
            fail("Expected exception for illegal number (too big, only <10 values are allowed");
        } catch (IllegalArgumentException ex) {
            // ignored
        }
    }

    @Test
    public void ofByteArray() {
        int[] inputData = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SimpleDecNumber num = SimpleDecNumber.of(inputData);

        int[] representation = num.representation();
        assertEquals(inputData.length,  representation.length);

        for (int i = 0; i < inputData.length; i++) {
            assertEquals("Digit " + i, inputData[i], representation[i]);
        }
    }

    @Test
    public void ofByteArrayExplicitPositive() {
        int[] inputData = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SimpleDecNumber num = SimpleDecNumber.of(inputData);

        int[] representation = num.representation();
        assertEquals(inputData.length,  representation.length);

        for (int i = 0; i < inputData.length; i++) {
            assertEquals("Digit " + i, inputData[i], representation[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void ofByteArrayTooBig() {
        SimpleDecNumber.of(new int[11]);
    }

    @Test
    public void testToString() {
        SimpleDecNumber num = SimpleDecNumber.of(new int[]{0,9,8,7,6,5,4,3,2,1});
        String strRep = num.toString();
        assertEquals("SimpleDecNumber(1234567890)", strRep);
    }

    @Test
    public void testToStringWZeroes() {
        SimpleDecNumber num = SimpleDecNumber.of(new int[]{5,4,3,2,1,0,0,0,0,0});
        String strRep = num.toString();
        assertEquals("SimpleDecNumber(0000012345)", strRep);
    }

    @Test
    public void addSimple1Digit() {
        SimpleDecNumber num1 = SimpleDecNumber.of(1);
        SimpleDecNumber num2 = SimpleDecNumber.of(2);

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);

        int[] resultRep = result.representation();
        assertArrayEquals("Result is correct", new int[] {3,0,0,0,0,0,0,0,0,0}, result.representation());
    }

    @Test
    public void addMultipleDigits() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {1,1,1,1,1,1,1,1,1,1});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {2,2,2,2,2,2,2,2,2,2});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);

        assertArrayEquals("Result is correct", new int[] {3,3,3,3,3,3,3,3,3,3}, result.representation());
    }

    @Test
    public void addMultipleDigits2() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {1,0,1,0,1,0,1,0,1,0});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {2,0,2,0,2,0,2,0,2,0});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);

        assertArrayEquals("Result is correct", new int[] {3,0,3,0,3,0,3,0,3,0}, result.representation());
    }

    @Test
    public void addMultipleDigitsWithZeros() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {0,0,0,0,0,1,1,1,1,1});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {0,0,0,0,0,2,2,2,2,2});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);

        assertArrayEquals("Result is correct", new int[] {0,0,0,0,0,3,3,3,3,3}, result.representation());
    }

    @Test
    public void addMultipleDigitsWithZeros2() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {1,1,1,1,1,0,0,0,0,0});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {2,2,2,2,2,0,0,0,0,0});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);

        assertArrayEquals("Result is correct", new int[] {3,3,3,3,3,0,0,0,0,0}, result.representation());
    }

    @Test
    public void add1DigitWithCarryOn() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {5,0,0,0,0,0,0,0,0,0});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {5,0,0,0,0,0,0,0,0,0});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num1Rep);

        assertArrayEquals("Result is correct", new int[] {0,1,0,0,0,0,0,0,0,0}, result.representation());
    }

    @Test
    public void add1WithCascadingCarryOn() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {9,9,9,9,9,9,9,9,9,0});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {1,0,0,0,0,0,0,0,0,0});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        SimpleDecNumber result = num1.add(num2);

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);
        assertArrayEquals("Result is correct", new int[] {0,0,0,0,0,0,0,0,0,1}, result.representation());
    }

    @Test
    public void add1WithCascadingCarryOnOverflow() {
        SimpleDecNumber num1 = SimpleDecNumber.of(new int[] {9,9,9,9,9,9,9,9,9,9});
        SimpleDecNumber num2 = SimpleDecNumber.of(new int[] {1,0,0,0,0,0,0,0,0,0});

        int[] origNum1Rep = num1.representation().clone();
        int[] origNum2Rep = num2.representation().clone();

        try {
            SimpleDecNumber result = num1.add(num2);
            fail("Expected exception - overflow after carryon");
        } catch (IllegalArgumentException ex) {
            // expected
        }

        int[] num1Rep = num1.representation();
        assertArrayEquals("Number 1 not changed", origNum1Rep, num1Rep);
        int[] num2Rep = num2.representation();
        assertArrayEquals("Number 1 not changed", origNum2Rep, num2Rep);
    }

//    @Test
//    public void sub() {
//        fail("TODO");
//    }
//
//    @Test
//    public void mul() {
//        fail("TODO");
//    }
}