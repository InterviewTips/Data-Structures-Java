package com.ronething.leetcode;

public class lc307 {
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

        public void update(int i, int val) {
//            // 1、更新 value
//            int diff = val - nums[i];
//            nums[i] = val;
//            // 2、更新索引
//            for (int j = i+1; j < sums.length; j++) {
//                sums[j] = sums[j] + diff;
//            }

            // 1、更新 value
            nums[i] = val;
            // 2、更新索引
            for (int j = i+1; j < sums.length; j++) {
                sums[j] = sums[j-1] + nums[j-1];
            }
        }

        public int sumRange(int i, int j) {
            // 1..2 表示 第2、3个元素之和, sums[3] - sums[1]
            return sums[j + 1] - sums[i];
        }

    }


}
