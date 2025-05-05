package org.example;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private final FibonacciSequence sequence;
    private int prev = 0;
    private int curr = 1;
    private int index = 0;
    private final int maxCount;


    public FibonacciIterator(FibonacciSequence sequence) {
        this.sequence = sequence;
        this.maxCount = Integer.MAX_VALUE;
    }

    public FibonacciIterator(FibonacciSequence sequence, int maxCount) {
        this.sequence = sequence;
        this.maxCount = maxCount;
    }

    @Override
    public boolean hasNext() {
        return index < maxCount;
    }

    @Override
    public Integer next() {
        int result;
        if (index == 0) {
            result = 1;
        } else {
            result = curr;
        }
        int next = sequence.generateNext(prev, curr);
        prev = curr;
        curr = next;
        index++;
        return result;
    }

}
