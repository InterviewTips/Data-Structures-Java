package com.ronething;

import java.util.Stack;

// T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0]
// The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
//
// 链接：https://leetcode-cn.com/problems/daily-temperatures
public class DailyTemperatures {
    // 时间复杂度 O(n^2)
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int current;
        for (int i = 0; i < T.length; i++) {
            current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i; // j = 1 , i = 0 过一天 -> j - i
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int[] dailyTemperaturesStack(int[] T) {

        int[] result = new int[T.length];
        Stack<Integer> s = new Stack<>();// 存的是元素索引,而不是元素本身
        for (int i = 0; i < T.length; i++) {
            while (!s.empty() && T[i] > T[s.peek()]) {
                // 栈不为空 且当前温度(数字) > s.peek()(栈顶元素) 那么取出栈顶元素且标记 result
                int t = s.peek(); // 取出栈顶元素
                result[t] = i - t;
                s.pop(); // 弹出元素
            }
            s.push(i); // 注意：push 的是元素索引
        }


        return result;
    }


    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures d = new DailyTemperatures();
        int[] result = d.dailyTemperatures(T);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        result = d.dailyTemperaturesStack(T);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

}
