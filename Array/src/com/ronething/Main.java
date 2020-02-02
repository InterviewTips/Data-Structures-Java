package com.ronething;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        array.add(1, 100);
        array.addFirst(-1); // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        array.remove(2); // [-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        array.removeElement(4); // [-1, 0, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println(array);
    }

}
