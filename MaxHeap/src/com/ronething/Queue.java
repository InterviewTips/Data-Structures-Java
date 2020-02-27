package com.ronething;

public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e); // 队尾存进元素

    E dequeue(); // 队首取出元素

    E getFront();
}
