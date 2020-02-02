package com.ronething;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        array.addLast(2);
        array.addLast(2);
        System.out.println(array);
        array.removeLast();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array);
    }

}
