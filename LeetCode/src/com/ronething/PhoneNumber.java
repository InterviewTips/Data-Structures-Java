package com.ronething;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    List<String> res = new ArrayList<>();
    String[] letterMap = new String[]{
            " ",  // 0
            "",   // 1
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };

    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits.equals("")) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // 递归调用
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        PhoneNumber p = new PhoneNumber();
        System.out.println((p.letterCombinations("")).size());
        System.out.println(p.letterCombinations("23"));
    }
}
