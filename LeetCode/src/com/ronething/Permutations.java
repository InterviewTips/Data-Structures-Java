package com.ronething;

import java.util.ArrayList;
import java.util.List;

// 递归 or 回溯
public class Permutations {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        if (nums.length == 0) {
            return res;
        }
        int[] visited = new int[nums.length];
        findCombination(nums, 0, new ArrayList<>(), visited);
        return res;
    }

    private void findCombination(int[] digits, int index, List<Integer> s, int[] visited) {
        if (index == digits.length) {
            res.add(new ArrayList<>(s)); // new 一个
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            // 递归调用
            s.add(digits[i]);
            findCombination(digits, index + 1, s, visited);
            visited[i] = 0; // 回退之后 要将此元素设置为没有 visited
//            System.out.println(s);
            s.remove(s.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(p.permute(nums));
    }
}
