package org.example;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        // Create a FibonacciSequence instance
        FibonacciSequence fibSeq = new FibonacciSequence();

        // Print the first 10 Fibonacci numbers using the sequence's iterator
        System.out.println("First 10 Fibonacci numbers (using Sequence):");
        Iterator<Integer> it = fibSeq.iterator();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Create a limited iterator directly with the sequence
        System.out.println("First 10 Fibonacci numbers (using limited iterator):");
        Iterator<Integer> limitedIt = new FibonacciIterator(fibSeq, 10);
        while (limitedIt.hasNext()) {
            System.out.print(limitedIt.next() + " ");
        }
        System.out.println();

        /*
         * Design Decision:
         * ----------------
         * While the FibonacciSequence class is responsible for generating the Fibonacci numbers
         * through its generateNext() method, the state of each iteration (the two most recent
         * numbers and the current position) is maintained within the FibonacciIterator class.
         *
         * Rationale:
         * - The sequence class provides the algorithm for generating numbers
         * - Each iterator maintains its own state, allowing multiple independent iterations
         * This design allows for multiple iterators to traverse the same sequence independently,
         * without interfering with each other's state.
         */
    }
}