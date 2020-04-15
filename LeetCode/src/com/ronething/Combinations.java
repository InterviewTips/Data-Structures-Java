package com.ronething;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        List<Integer> c = new ArrayList<>();
        generateCombinations(n, k, 1, c);
        return res;
    }

    private void generateCombinations(int n, int k, int start, List<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        for (int i = start; i <= n; i++) {
            c.add(i);
            generateCombinations(n, k, i + 1, c);
//            System.out.println(start + " " + c);
            c.remove(c.size() - 1);
        }

        return;
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }

}
