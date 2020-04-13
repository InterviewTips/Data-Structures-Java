package com.ronething;

import java.util.Hashtable;

public class LRUCache<E> {

    class DLinkedNode {
        E key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private Hashtable<E, DLinkedNode>
            cache = new Hashtable<>(); // HashMap 映射
    private int count; // 节点数量
    private int capacity; // lru cache 容量
    private DLinkedNode head, tail; // 双向链表首尾节点

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(E key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    // add or set
    public void set(E key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // add
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode); // 映射增加
            this.addNode(newNode); // 双向链表增加节点

            ++count; // 节点数量增加 1

            if (count > capacity) {
                // 如果超出容量，需要 pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(2 /* 缓存容量 */);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1)); // 返回  1
        cache.set(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2)); // 返回 -1 (未找到)
        cache.set(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        System.out.println(cache.get(3)); // 返回  3
        System.out.println(cache.get(4));// 返回  4

    }
}
