package com.ronething;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;

        public Node left;
        public Node right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }

    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    // 返回节点高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balancedFactor = getBalanceFactor(node);
        if (balancedFactor > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
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

        // 更新 height
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));

        // 平衡因子
        int balanceFactor = getBalanceFactor(n);
//        if (balanceFactor > 1) {
//            System.out.println("unbalanced: " + balanceFactor);
//        }

        // 平衡维护

        // LL
        if (balanceFactor > 1 && getBalanceFactor(n.left) >= 0) {
            return rightRotate(n);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(n.right) <= 0) {
            return leftRotate(n);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(n.left) < 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(n.right) > 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }

        return n;
    }

    // 右旋转
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        // 旋转操作
        x.right = y;
        y.left = t3;
        // 更新 height 先更新 y
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 左旋转
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;
        // 旋转操作
        x.left = y;
        y.right = t2;
        // 更新 height 先更新 y
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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

        Node retN;
        if (key.compareTo(n.key) > 0) {
            n.right = remove(n.right, key);
            retN = n;
        } else if (key.compareTo(n.key) < 0) {
            n.left = remove(n.left, key);
            retN = n;
        } else { // key.equals(n.key)

            // 右子树为空
            if (n.right == null) {
                Node leftNode = n.left;
                n.left = null;
                size--;
                retN = leftNode;
            }
            // 左子树为空
            else if (n.left == null) {
                Node rightNode = n.right;
                n.right = null;
                size--;
                retN = rightNode;
            } else {
                Node s = minimum(n.right);
//            s.right = removeMin(n.right); removeMin 中没有进行平衡维护
                s.right = remove(n.right, s.key); // 等价 removeMin(n.right)
                s.left = n.left;
                n.left = n.right = null;
                retN = s;
            }
        }

        if(retN == null){
            return null;
        }

        // 更新 height
        retN.height = 1 + Math.max(getHeight(retN.left), getHeight(retN.right));

        // 平衡因子
        int balanceFactor = getBalanceFactor(retN);

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retN.left) >= 0) {
            return rightRotate(retN);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(retN.right) <= 0) {
            return leftRotate(retN);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(retN.left) < 0) {
            retN.left = leftRotate(retN.left);
            return rightRotate(retN);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(retN.right) > 0) {
            retN.right = rightRotate(retN.right);
            return leftRotate(retN);
        }

        return retN;

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
        AVLTree<String, Integer> map = new AVLTree<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);

        for (String w : words) {
            Integer sum = map.get(w);
            if (sum != null) { // +1
                map.set(w, sum + 1);
            } else { // add
                map.add(w, 1);
            }
        }

        System.out.println("AVLTree: " + words.size());
        System.out.println(map.getSize());
        System.out.println(map.isBST());
        System.out.println(map.isBalanced());
        for (String w :
                words) {
            map.remove(w);
            if(!map.isBST() || !map.isBalanced()){
                throw new RuntimeException("error");
            }
        }
//        System.out.println(map.get("project"));

    }

}
