package com.ronething;

import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;

        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 显示声明
        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node != null) {// if exist then set
            node.value = value;
        } else { // else then insert
            dummyHead.next = new Node(key, value, dummyHead.next); // 相当于 addFirst
            size++;
        }
    }

    @Override
    public V remove(K key) {
        // 找到前驱
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return prev.value;
            }
            prev = prev.next;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {// if not exist then throw
            throw new IllegalArgumentException(key + "doesn't exist!");
        } else { // else then set
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder res = new StringBuilder();
        while (cur != null) {
            res.append(cur).append("\n");
            cur = cur.next;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // 词频统计
        ArrayList<String> words = new ArrayList<>();
        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("linkedListMap: " + words.size());

        for (String w : words) {
            Integer sum = map.get(w);
            if (sum != null) { // +1
                map.set(w, sum + 1);
            } else { // add
                map.add(w, 1);
            }
        }

        System.out.println(map.getSize());
//        System.out.println(map.get("project"));

    }


}
