package com.ronething;

// list node class
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("arr can not be empty");
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next= new ListNode(arr[i]);
            cur = cur.next;
        }
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
