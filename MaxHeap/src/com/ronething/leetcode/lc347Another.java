package com.ronething.leetcode;


import java.util.*;

public class lc347Another {

    private class Freq {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqCompartor implements Comparator<Freq> {

        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
        }
    }

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
            PriorityQueue<Freq> queue = new PriorityQueue<>(new FreqCompartor());

            for (int key : map.keySet()) {
                if (queue.size() < k) {
                    queue.add(new Freq(key, map.get(key)));
                } else if (map.get(key) > queue.peek().freq) {
                    queue.remove();
                    queue.add(new Freq(key, map.get(key)));
                }
            }

            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                list.add(queue.remove().e);
            }

            Collections.reverse(list);
            return list;
        }
    }
}
