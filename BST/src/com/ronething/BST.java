package com.ronething;

public class BST<E extends Comparable<E>> {// E 需要具有可比较性

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    // 返回插入新插入节点后的根
    private Node add(Node n, E e) {
//        普通做法
//        if (e.equals(n.e))
//            return;
//        else if (e.compareTo(n.e) < 0 && n.left == null) {
//            n.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(n.e) > 0 && n.right == null) {
//            n.right = new Node(e);
//            size++;
//            return;
//        }

        if (n == null) {// 走到空就可以插入节点了
            size++;
            return new Node(e);
        }

        // 等于则什么都不做
        if (e.compareTo(n.e) < 0)
            n.left = add(n.left, e);
        else if (e.compareTo(n.e) > 0)
            n.right = add(n.right, e);

        return n;

    }

    public boolean contains(E e) {

        return contains(root, e);
    }

    private boolean contains(Node n, E e) {
        if (n == null) {
            return false;
        }
        if (e.compareTo(n.e) < 0) {
            return contains(n.left, e);
        } else if (e.compareTo(n.e) > 0) {
            return contains(n.right, e);
        } else return true;
    }

    public static void main(String[] args) {

    }
}
