package com.ronething.leetcode;

import java.util.TreeMap;

public class lc211 {
    class WordDictionary {

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

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        // 添加一个单词
        public void addWord(String word) {
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
            return match(root, word, 0);
        }

        private boolean match(Node node, String word, int index) {
            if (index == word.length()) {
                return node.isWord;
            }

            char c = word.charAt(index);
            if (c != '.') {
                if (node.next.get(c) == null) {
                    return false;
                }
                return match(node.next.get(c), word, index + 1);
            } else { // if c == '.' match all
                for (char n : node.next.keySet()) {
                    if (match(node.next.get(n), word, index + 1)) { // 有一个成功就可以返回 true
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
