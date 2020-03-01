package com.ronething.leetcode;

public class lc303Another {
    class NumArray {

        private int[] sums;
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            // 1..2 表示 第2、3个元素之和, sums[3] - sums[1]
            return sums[j + 1] - sums[i];
        }

    }

}
