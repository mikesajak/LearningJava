package org.mikesajak.javaschool.lesson01;

public interface DecimalNumber {
    DecimalNumber add(DecimalNumber other); // add other number from this num and return new number as a result
    DecimalNumber sub(DecimalNumber other); // subtract other number from this and return new number as a result
    DecimalNumber mul(DecimalNumber other); // multiply

    int numDigits(); // get num digits
    int digit(int i);
    int capacity(); // get internal data structure size (for testing)
    int[] representation(); // get internal representation (for testing)
}
