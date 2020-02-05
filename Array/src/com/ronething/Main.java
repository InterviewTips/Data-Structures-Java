package com.ronething;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(4);

        for (int i = 0; i < 4; i++) {
            array.addLast(i);
        }

        array.addLast(2);
        array.removeLast();
        System.out.println(array); // 此时 capacity 应为 8 lazy
        array.removeLast();
        array.removeLast();
        System.out.println(array); // 此时 capacity 应为 4 lazy
    }

}
