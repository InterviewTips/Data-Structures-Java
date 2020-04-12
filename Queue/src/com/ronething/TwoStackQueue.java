package com.ronething;

public class TwoStackQueue<E> implements Queue<E> {

    private Stack<E> stackA = new ArrayStack<>(); // 用于入队
    private Stack<E> stackB = new ArrayStack<>(); // 用于出队

    @Override
    public int getSize() {
        return stackA.getSize() + stackB.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        System.out.println("push " + e);
        stackA.push(e);
    }

    @Override
    public E dequeue() {
        // 出队操作
        if (!stackB.isEmpty()) {
            return stackB.pop();
        } else {
            if (!stackA.isEmpty()) {
                // stackA 元素循环出栈然后入栈 stackB
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop()); // 可以分解为如下两步
//                    stackB.push(stackA.peek());
//                    stackA.pop();
                }

                return stackB.pop();
            } else {
                throw new IllegalArgumentException("queue is empty!");
            }
        }
    }

    @Override
    public E getFront() {
        return stackB.peek();
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new TwoStackQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        } // 入队：0 1 2 3 4
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        } // 出队：0 1 2 3 4
    }
}

