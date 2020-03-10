package com.ronething;


import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;

        public Node left;
        public Node right;
        public boolean color; //

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED; // 默认颜色为红色
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }

    }

    private Node root;
    private int size;

    public RBTree() {
        this.root = null;
        this.size = 0;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void filpColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK; // 最终根节点为黑色节点
    }

    private Node add(Node n, K key, V value) {
        if (n == null) {// 走到空就可以插入节点了
            size++;
            return new Node(key, value); // 默认插入红色节点
        }

        // 等于则什么都不做
        if (key.compareTo(n.key) < 0)
            n.left = add(n.left, key, value);
        else if (key.compareTo(n.key) > 0)
            n.right = add(n.right, key, value);
        else // key.compareTo(n.key) == 0
            n.value = value;

        if (isRed(n.right) && !isRed(n.left)) {
            n = leftRotate(n);
        }

        if (isRed(n.left) && isRed(n.left.left)) {
            n = rightRotate(n);
        }

        if (isRed(n.left) && isRed(n.right)) {
            filpColors(n);
        }

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


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node n = getNode(root, key);
        return n == null ? null : n.value;
    }

    public void set(K key, V newValue) {
        Node n = getNode(root, key);
        if (n == null) throw new IllegalArgumentException(key + "doesn't not exist");
        n.value = newValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        // 词频统计
        ArrayList<String> words = new ArrayList<>();
        RBTree<String, Integer> map = new RBTree<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("RBTree: " + words.size());

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
