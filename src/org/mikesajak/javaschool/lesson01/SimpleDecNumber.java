package org.mikesajak.javaschool.lesson01;

public class SimpleDecNumber implements DecimalNumber {
    // some fields to hold data

    private SimpleDecNumber(/*...*/) {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    static SimpleDecNumber of(int value) {
        // TODO some validation,
            //throw new IllegalArgumentException("Value must be >= 0 and < 10");

//        return new SimpleDecNumber(/*...*/);
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    public static SimpleDecNumber of(int[] data) {
        // TODO:...
        throw new UnsupportedOperationException("Not implemented yet...");
//         return new SimpleDecNumber(???);
    }

    // TODO: fill with methods to implement interface

    @Override
    public SimpleDecNumber add(DecimalNumber other) {
        throw new UnsupportedOperationException("Not implemented yet...");

        // TODO...
        //return new SimpleDecNumber( /* result */);
    }

    @Override
    public SimpleDecNumber sub(DecimalNumber other) {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    @Override
    public SimpleDecNumber mul(DecimalNumber other) {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    @Override
    public int numDigits() {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    @Override
    public int digit(int i) {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    @Override
    public int capacity() {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    @Override
    public int[] representation() {
        throw new UnsupportedOperationException("Not implemented yet...");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SimpleDecNumber(");
        // TODO...

        sb.append("...")
                .append(")");
        return sb.toString();
    }
}
