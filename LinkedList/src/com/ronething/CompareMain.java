package com.ronething;

import java.util.Random;

public class CompareMain {

    private static double testStack(Stack<Integer> s, int OpCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < OpCount; i++) s.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < OpCount; i++) s.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int OpCount = 100000;

//        for (int i = 0; i < 10; i++) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("array stack time: " + testStack(arrayStack, OpCount));
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("linkedList stack time: " + testStack(linkedListStack, OpCount));
//        }

    }
}
