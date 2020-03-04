package com.ronething.leetcode;

import java.util.TreeMap;

public class lc208 {
    class Trie {

        private class Node {
            public boolean isWord;
            public TreeMap<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>(); // 保证不为 null
            }

            public Node() {
                this(false);
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }


        // 添加一个单词
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.next.putIfAbsent(c, new Node());
                cur = cur.next.get(c); // 下个节点一定会走到
            }

            if (!cur.isWord) {
                cur.isWord = true;
            }
        }

        public boolean search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }

            return cur.isWord;
        }


        public boolean startsWith(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }

            return true;
        }

    }

}
