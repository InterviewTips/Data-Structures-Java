package com.ronething;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100, 99, 89};
        print_score(scores);

        scores[0] = 88;

        print_score(scores);

    }

    private static void print_score(int[] scores) {
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
