package com.ronething;

import java.util.*;

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

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 层序遍历(广度优先)
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    private Node minimum(Node n) {
        if (n.left == null)
            return n;
        return minimum(n.left);
    }

    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    private Node maximum(Node n) {
        if (n.right == null)
            return n;
        return maximum(n.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
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

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node n) {
        if (n.right == null) {
            Node leftNode = n.left;
            n.left = null;
            size--;
            return leftNode;
        }

        n.right = removeMax(n.right);
        return n;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty())
            arrayList.add(bst.removeMin());
        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) > arrayList.get(i))
                throw new IllegalArgumentException("error");
        }

        System.out.println("removeMin done");

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        arrayList = new ArrayList<>();
        while (!bst.isEmpty())
            arrayList.add(bst.removeMax());
        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) < arrayList.get(i))
                throw new IllegalArgumentException("error");
        }

        System.out.println("removeMax done");

    }
}
