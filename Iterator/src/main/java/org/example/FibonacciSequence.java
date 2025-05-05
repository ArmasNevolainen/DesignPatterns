package org.example;

import java.util.Iterator;

public class FibonacciSequence implements Sequence{

    public int generateNext(int prev, int curr) {
        return prev + curr;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}
