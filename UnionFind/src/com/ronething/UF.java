package com.ronething;

// 并查集接口
public interface UF {

    int getSize();

    boolean isConnected(int p, int q); // 索引

    void unionElements(int p, int q); // 将两个元素进行并操作

}
