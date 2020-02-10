package com.ronething;


import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int OpCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < OpCount; i++) q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < OpCount; i++) q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int OpCount = 100000;

//        for (int i = 0; i < 10; i++) {
            LoopQueue<Integer> loopQueue = new LoopQueue<>();
            System.out.println("loop queue time: " + testQueue(loopQueue, OpCount));
            ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
            System.out.println("array queue time: " + testQueue(arrayQueue, OpCount));
//        }

    }
}
