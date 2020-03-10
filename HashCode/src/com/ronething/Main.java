package com.ronething;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 词频统计
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {


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

            RBTree<String, Integer> rbTree = new RBTree<>();
            startTime = System.nanoTime();
            for (String w : words) {
                Integer sum = rbTree.get(w);
                if (sum != null) { // +1
                    rbTree.set(w, sum + 1);
                } else { // add
                    rbTree.add(w, 1);
                }
            }

            for (String w : words) {
                rbTree.contains(w);
            }

            endTime = System.nanoTime();

            System.out.println("RBTree: " + (endTime - startTime) / 1000000000.0);

            HashTable<String, Integer> hashTable = new HashTable<>();
            startTime = System.nanoTime();
            for (String w : words) {
                Integer sum = hashTable.get(w);
                if (sum != null) { // +1
                    hashTable.set(w, sum + 1);
                } else { // add
                    hashTable.add(w, 1);
                }
            }

            for (String w : words) {
                hashTable.contains(w);
            }

            endTime = System.nanoTime();

            System.out.println("HashTable: " + (endTime - startTime) / 1000000000.0);
            //Output:
            //BST: 0.115259792
            //AVL: 0.109475394
            //RBTree: 0.106478532
            //HashTable: 0.082350348
        }


    }
}
