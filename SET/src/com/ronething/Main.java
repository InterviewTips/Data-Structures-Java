package com.ronething;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        bstSetSummary("pride-and-prejudice.txt");
        linkedListSetSummary("pride-and-prejudice.txt");


        System.out.println("A Tale Of Two Cities");

        bstSetSummary("a-tale-of-two-cities.txt");
        linkedListSetSummary("a-tale-of-two-cities.txt");
    }

    private static void linkedListSetSummary(String filename) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename, words);
        System.out.println("linkedListSet: " + words.size());


        Set<String> set = new LinkedListSet<>();
        for (String w : words) {
            set.add(w);
        }

        System.out.println("linkedListSet: " + set.getSize());
    }

    private static void bstSetSummary(String filename) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename, words);
        System.out.println("bstSet: " + words.size());


        Set<String> set = new BSTSet<>();
        for (String w : words) {
            set.add(w);
        }

        System.out.println("bstSet: " + set.getSize());
    }
}
