package com.ronething;

public class SegmentTree<E> {

    private E[] tree; // 满二叉树
    private E[] data;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length]; // 4n capacity

    }

    public int getSize() {
        return data.length;
    }

    public E getIndex(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];

    }


    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

}
