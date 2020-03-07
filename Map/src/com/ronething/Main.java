package com.ronething;

import java.util.ArrayList;

public class Main {

    private static double testMap(Map<String, Integer> map) {
        long StartTime = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("Total size: " + words.size());

        for (String w : words) {
            Integer sum = map.get(w);
            if (sum != null) { // +1
                map.set(w, sum + 1);
            } else { // add
                map.add(w, 1);
            }
        }

        System.out.println(map.getSize());


        long EndTime = System.nanoTime();

        return (EndTime - StartTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        Map<String, Integer> linkedListMap = new LinkedListMap<>();
        System.out.println(testMap(linkedListMap));
        Map<String, Integer> bstMap = new BSTMap<>();
        System.out.println(testMap(bstMap));
        Map<String, Integer> avlMap = new AVLMap<>();
        System.out.println(testMap(avlMap));
    }
}
