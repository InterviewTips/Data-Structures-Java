package com.ronething;

import sun.jvm.hotspot.debugger.bsd.amd64.BsdAMD64CFrame;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;

        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }

    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node n, K key, V value) {
        if (n == null) {// 走到空就可以插入节点了
            size++;
            return new Node(key, value);
        }

        // 等于则什么都不做
        if (key.compareTo(n.key) < 0)
            n.left = add(n.left, key, value);
        else if (key.compareTo(n.key) > 0)
            n.right = add(n.right, key, value);
        else // key.compareTo(n.key) == 0
            n.value = value;

        return n;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else  // key.compareTo(node.right) > 0
            return getNode(node.right, key);
    }

    @Override
    public V remove(K key) {
        Node n = getNode(root, key);
        if (n != null) {
            root = remove(root, key);
            return n.value;
        }
        return null;
    }

    private Node remove(Node n, K key) {
        if (n == null) {
            return null;
        }

        if (key.compareTo(n.key) > 0) {
            n.right = remove(n.right, key);
            return n;
        } else if (key.compareTo(n.key) < 0) {
            n.left = remove(n.left, key);
            return n;
        } else { // key.equals(n.key)

            // 右子树为空
            if (n.right == null) {
                Node leftNode = n.left;
                n.left = null;
                size--;
                return leftNode;
            }

            // 左子树为空
            if (n.left == null) {
                Node rightNode = n.right;
                n.right = null;
                size--;
                return rightNode;
            }

            Node s = minimum(n.right);
            s.right = removeMin(n.right);
            s.left = n.left;
            n.left = n.right = null;
            return s;
        }
    }

    private Node minimum(Node n) {
        if (n.left == null)
            return n;
        return minimum(n.left);
    }

    private Node removeMin(Node n) {
        if (n.left == null) {
            Node rightNode = n.right;
            n.right = null;
            size--;
            return rightNode;
        }

        n.left = removeMin(n.left);
        return n;

    }


    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node n = getNode(root, key);
        return n == null ? null : n.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node n = getNode(root, key);
        if (n == null) throw new IllegalArgumentException(key + "doesn't not exist");
        n.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        // 词频统计
        ArrayList<String> words = new ArrayList<>();
        BSTMap<String, Integer> map = new BSTMap<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("BSTMap: " + words.size());

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
