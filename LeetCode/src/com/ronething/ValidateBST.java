package com.ronething;

public class ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean bst(TreeNode root, Integer lower, Integer upper) {
        // upper 节点上界
        // lower 节点下界
        if (root == null) {
            return true; // root 为空树，默认返回 true
        }

        int val = root.val;
        if (lower != null && val <= lower) { // 比下界还小
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!bst(root.right, val, upper)) return false;
        if (!bst(root.left, lower, val)) return false;

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return bst(root, null, null);
    }
}
