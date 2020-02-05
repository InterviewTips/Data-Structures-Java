package com.ronething;

public class Array<E> { // E 表示数据类型
    private E[] data;
    private int size; // 没有存放元素的第一个索引

    // 无参构造方法 初始化容量 10
    public Array() {
        this(10);
    }

    // 构造方法
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
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

    // 获取索引对应的元素值
    public E get(int index) {
        if (index <= 0 || index > size)
            throw new IllegalArgumentException("Get failed. Index is illegal");

        return data[index];
    }

    // 修改对应索引的值
    public void set(int index, E e) {
        if (index <= 0 || index > size)
            throw new IllegalArgumentException("Get failed. Index is illegal");

        data[index] = e;
    }

    // 索引是否存在
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return true;
        }
        return false;
    }

    // 返回元素索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    // 删除元素
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add last func failed. Require index>=0 and index<=size");

        E e = data[index];
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--;
//        data[size] = null; // loitering objects != memory leak
        // 动态缩容 eager
//        if (size == data.length / 2) resize(data.length / 2);
        // lazy
        if (size == data.length / 4) resize(data.length / 2);
        return e;
    }

    // 删除末尾元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除首元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除指定元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) remove(index);
    }

    // 数组末尾添加元素
    public void addLast(E i) {
        add(size, i);
    }

    // 数组首添加元素
    public void addFirst(E i) {
        add(0, i);
    }

    // 在第 index 个位置插入一个新元素 e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add last func failed. Require index>=0 and index<=size");

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    // 动态扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData; // 引用
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) res.append(", ");
        }
        res.append("]");

        return res.toString();
    }
}
