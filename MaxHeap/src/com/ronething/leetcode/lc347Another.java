package com.ronething.leetcode;


import java.util.*;

public class lc347Another {

    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o1) - map.get(o2);
                }
            });

            for (int key : map.keySet()) {
                if (queue.size() < k) {
                    queue.add(key);
                } else if (map.get(key) > map.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }

            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                list.add(queue.remove());
            }

            Collections.reverse(list);
            return list;
        }
    }
}
