package com.ronething;

public class BST<E extends Comparable<E>> {// E 需要具有可比较性
    private class Node{
        public E e ;
        public Node left, right;

        public Node(E e ){
            this.e = e ;
            left = null;
            right = null;
        }
    }

    private Node root;
    private  int size;

    public BST(){
        root = null;
        size= 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public static void main(String[] args) {

    }
}
