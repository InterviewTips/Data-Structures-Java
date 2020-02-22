package com.ronething.leetcode;

import java.util.TreeSet;

public class lc804 {
    static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                    "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


            TreeSet<String> set = new TreeSet<>();
            for (String w : words) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < w.length(); i++) {
                    res.append(codes[w.charAt(i) - 'a']);
                }
                String r = res.toString();
                System.out.println(w + " " + r);
                set.add(r);
            }

            System.out.println(set);
            return set.size();
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
