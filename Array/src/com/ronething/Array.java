package com.ronething;

public class Array {
    private int[] data;
    private int size; // 没有存放元素的第一个索引

    // 无参构造方法 初始化容量 10
    public Array() {
        this(10);
    }

    // 构造方法
    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    // 数组元素个数
    public int getSize() {
        return size;
    }

    // 数组容量
    public int getCapacity() {
        return data.length;
    }

    // 数组是否没有元素
    public boolean isEmpty() {
        return size == 0;
    }

    // 数组末尾添加元素
    public void addLast(int i) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("add last func failed. Array is full");
//        }
//        data[size] = i;
//        size++;
        add(size, i);
    }

    // 数组首添加元素
    public void addFirst(int i) {
        add(0, i);
    }

    // 在第 index 个位置插入一个新元素 e
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add last func failed. Array is full");
        }

        if (e < 0 || e > size) {
            throw new IllegalArgumentException("add last func failed. Require index>=0 and index<=size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


}
