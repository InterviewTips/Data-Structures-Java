package com.ronething;

// list node class
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(val).append("->");
        while (next != null) {
            res.append(next.val).append("->");
            next = next.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
