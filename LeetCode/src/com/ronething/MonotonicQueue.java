package com.ronething;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {
    private Deque<Integer> d = new ArrayDeque<>();

    private void push(int n) {
        while (!d.isEmpty() && d.peekLast() < n)
            d.removeLast();
        d.addLast(n);
    }

    private int max() {
        if (!d.isEmpty()) {
            return d.peekFirst();
        }
        throw new IllegalArgumentException("deque is empty");
    }

    private void pop(int n) {
        if (!d.isEmpty() && d.peekFirst() == n) {
            d.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列已有
        int[] result = new int[nums.length - (k - 1)];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                push(nums[i]);
            } else {
                push(nums[i]);
                result[i - (k - 1)] = max();
                pop(nums[i - (k - 1)]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = new MonotonicQueue().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
