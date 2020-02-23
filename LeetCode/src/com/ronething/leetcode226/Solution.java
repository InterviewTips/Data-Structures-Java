package com.ronething.leetcode226;

// 226. Invert Binary Tree
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = root.left; // l 需要先暂存 因为下一步 root.left 被赋值了
        root.left = invertTree(root.right);
        root.right = invertTree(l);
        return root;
    }

    public static void main(String[] args) {
    }

}
