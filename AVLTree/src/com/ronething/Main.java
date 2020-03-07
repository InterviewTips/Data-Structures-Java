package com.ronething;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        // 词频统计
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            Collections.sort(words); // 进行排序 二分搜索树退化成链表
            //Output:
            //BST: 16.450231591
            //AVL: 0.070104507

            BST<String, Integer> bst = new BST<>();
            long startTime = System.nanoTime();
            for (String w : words) {
                Integer sum = bst.get(w);
                if (sum != null) { // +1
                    bst.set(w, sum + 1);
                } else { // add
                    bst.add(w, 1);
                }
            }

            for (String w : words) {
                bst.contains(w);
            }

            long endTime = System.nanoTime();

            System.out.println("BST: " + (endTime - startTime) / 1000000000.0);

            AVLTree<String, Integer> avl = new AVLTree<>();
            startTime = System.nanoTime();
            for (String w : words) {
                Integer sum = avl.get(w);
                if (sum != null) { // +1
                    avl.set(w, sum + 1);
                } else { // add
                    avl.add(w, 1);
                }
            }

            for (String w : words) {
                avl.contains(w);
            }

            endTime = System.nanoTime();

            System.out.println("AVL: " + (endTime - startTime) / 1000000000.0);
        }


    }
}
