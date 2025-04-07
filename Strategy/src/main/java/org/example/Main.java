package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100000);

        SortingStrategy heapSort = new HeapSorting();
        SortingStrategy selectionSort = new SelectionSorting();
        SortingStrategy combSort = new CombSorting();

        SortingContext context = new SortingContext(heapSort);

        // Heap Sort
        int[] smallArrayCopy1 = Arrays.copyOf(smallArray, smallArray.length);
        context.setSortingStrategy(heapSort);
        long startTime = System.nanoTime();
        context.sort(smallArrayCopy1);
        long endTime = System.nanoTime();
        System.out.println("Heap Sort small array: " + (endTime - startTime));
        int[] largeArrayCopy1 = Arrays.copyOf(largeArray, largeArray.length);
        context.setSortingStrategy(heapSort);
        startTime = System.nanoTime();
        context.sort(largeArrayCopy1);
        endTime = System.nanoTime();
        System.out.println("Heap Sort large array: " + (endTime - startTime));

        // Selection Sort
        int[] smallArrayCopy2 = Arrays.copyOf(smallArray, smallArray.length);
        context.setSortingStrategy(selectionSort);
        startTime = System.nanoTime();
        context.sort(smallArrayCopy2);
        endTime = System.nanoTime();
        System.out.println("Selection Sort small array: " + (endTime - startTime));
        int[] largeArrayCopy2 = Arrays.copyOf(largeArray, largeArray.length);
        context.setSortingStrategy(selectionSort);
        startTime = System.nanoTime();
        context.sort(largeArrayCopy2);
        endTime = System.nanoTime();
        System.out.println("Selection Sort large array: " + (endTime - startTime));

        // Comb Sort
        int[] smallArrayCopy3 = Arrays.copyOf(smallArray, smallArray.length);
        context.setSortingStrategy(combSort);
        startTime = System.nanoTime();
        context.sort(smallArrayCopy3);
        endTime = System.nanoTime();
        System.out.println("Comb Sort small array: " + (endTime - startTime));
        int[] largeArrayCopy3 = Arrays.copyOf(largeArray, largeArray.length);
        context.setSortingStrategy(combSort);
        startTime = System.nanoTime();
        context.sort(largeArrayCopy3);
        endTime = System.nanoTime();
        System.out.println("Comb Sort large array: " + (endTime - startTime));
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000); // Random numbers between 0 and 999,999
        }

        return array;
    }
}