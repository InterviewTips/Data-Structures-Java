package com.ronething.leetcode;

import com.ronething.Merger;
import com.ronething.SegmentTree;

public class lc307Another {
    class NumArray {

        private SegmentTree<Integer> segmentTree;

        public NumArray(int[] nums) {

            if (nums.length > 0) {
                Integer[] data = new Integer[nums.length];

                for (int i = 0; i < nums.length; i++) {
                    data[i] = nums[i];
                }
                segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                    @Override
                    public Integer merge(Integer a, Integer b) {
                        return a + b;
                    }
                });
            }
        }

        public void update(int i, int val){
            segmentTree.set(i, val);
        }

        public int sumRange(int i, int j) {
            if (segmentTree == null) {
                throw new IllegalArgumentException("segement tree no init");
            }
            return segmentTree.query(i, j);
        }

    }
}
