package com.ronething.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 如果不是上述左括号
                if (stack.isEmpty()) return false;
                char topC = stack.pop();
                if (c == ')' && topC != '(') return false;
                if (c == ']' && topC != '[') return false;
                if (c == '}' && topC != '{') return false;
            }
        }
        return stack.isEmpty(); // 如果不为空说明没有全部匹配完
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("[]()"));
        System.out.println(new ValidParentheses().isValid("[(])"));
    }
}
