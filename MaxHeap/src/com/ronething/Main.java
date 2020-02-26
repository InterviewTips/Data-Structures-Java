package com.ronething;

import java.util.Random;

public class Main {

    public static double testHead(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();


        MaxHeap<Integer> maxHeap;
        if (isHeapify) { // O(n)
            maxHeap = new MaxHeap<>(testData);
        } else { // O(nlogn)
            maxHeap = new MaxHeap<>();
            for (Integer tD : testData) {
                maxHeap.add(tD);
            }
        }

        long endTime = System.nanoTime();

//        int[] arr = new int[testData.length];
//        for (int i = 0; i < testData.length; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//
//        for (int i = 1; i < testData.length; i++) {
//            if (arr[i] > arr[i - 1])
//                throw new IllegalArgumentException("Error");
//        }
//
//        System.out.println("Test MaxHeap completed.");

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
        int n = 10000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//
//        for (int i = 1; i < n; i++) {
//            if (arr[i] > arr[i - 1])
//                throw new IllegalArgumentException("Error");
//        }
//
//        System.out.println("Test MaxHeap completed.");
//

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        System.out.println(testHead(arr, true));
        System.out.println(testHead(arr, false));

    }
}
