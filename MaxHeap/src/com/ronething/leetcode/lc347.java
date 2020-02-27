package com.ronething.leetcode;

import com.ronething.PriorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class lc347 {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            // 频次越低 优先级越高
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;

            return 0;
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
            PriorityQueue<Freq> queue = new PriorityQueue<>();

            for (int key : map.keySet()) {
                if (queue.getSize() < k) {
                    queue.enqueue(new Freq(key, map.get(key)));
                } else if (map.get(key) > queue.getFront().freq) {
                    queue.dequeue();
                    queue.enqueue(new Freq(key, map.get(key)));
                }
            }

            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                list.add(queue.dequeue().e);
            }

            Collections.reverse(list);
            return list;
        }
    }
}
