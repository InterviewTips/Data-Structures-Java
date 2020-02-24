package com.ronething;

public class MapHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MapHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MapHeap() {
        this.data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 计算索引对应节点父节点索引
    private int parent(int index) {
        if (index == 0) throw new IllegalArgumentException("index-0 doesn't have parent.");

        return (index - 1) / 2;
    }

    // 计算索引对应节点左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 计算索引对应节点右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }


}
