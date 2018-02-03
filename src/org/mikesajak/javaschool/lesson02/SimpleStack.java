package org.mikesajak.javaschool.lesson02;

import java.util.List;

public interface SimpleStack {
    void push(int value); // put number on top of stack
    int pop(); // take number from the tip of the stack
    int peek(); // see the current value on the tip of the stack

    void clear();
    int size();

    List<Integer> getStackContents();
}
