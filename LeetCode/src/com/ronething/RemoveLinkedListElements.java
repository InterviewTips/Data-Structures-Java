package com.ronething;

// 203. Remove Linked List Elements
// Remove all elements from a linked list of integers that have value val.
// Example:
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5
public class RemoveLinkedListElements {

    public static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                ListNode node = head;
                head = head.next;
                node.next = null;
            }
            if (head == null) return head;

            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    ListNode node = prev.next;
                    prev.next = node.next;
                    node.next = null;
                } else {
                    prev = prev.next;
                }
            }

            return head;
        }

    }

    public static class Solution2 {
        public ListNode removeElements(ListNode head, int val) {

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode prev = dummyHead;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    ListNode node = prev.next;
                    prev.next = node.next;
                    node.next = null;
                } else {
                    prev = prev.next;
                }
            }

            return dummyHead.next;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 5, 3, 2};
        ListNode l = new ListNode(nums);
        System.out.println(l);
        System.out.println(s.removeElements(l, 2));

    }
}
