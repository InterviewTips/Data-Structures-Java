package com.ronething.leetcode349;

import java.util.ArrayList;
import java.util.TreeSet;

// 349. Intersection of Two Arrays
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1) {
            treeSet.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (treeSet.contains(num)) { // 有交集
                // solution 1
                if (!list.contains(num))
                    list.add(num);
                // solution 2
//                list.add(num);
//                treeSet.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
