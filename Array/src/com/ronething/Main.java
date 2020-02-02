package com.ronething;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        array.add(1, 100);
        array.addFirst(-1);
        System.out.println(array);
    }

}
