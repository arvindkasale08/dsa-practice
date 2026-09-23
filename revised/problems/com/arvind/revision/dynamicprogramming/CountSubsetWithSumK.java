package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class CountSubsetWithSumK {

    public int perfectSum(int[] arr, int k) {
        int[][] dp = new int[arr.length][k+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return perfectSumMemo(0, arr, k, dp);
        //return perfectSumRecur(0, arr, k);
    }

    private int perfectSumMemo(int i, int[] arr, int k, int[][] dp) {
        if (i >= arr.length) return k == 0 ? 1 : 0;
        if (k < 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        dp[i][k] = perfectSumMemo(i+1, arr, k, dp) + perfectSumMemo(i+1, arr, k-arr[i], dp);
        return dp[i][k];
    }

    private int perfectSumRecur(int i, int[] arr, int k) {
        if (i >= arr.length) return k == 0 ? 1 : 0;
        if (k < 0) return 0;

        return perfectSumRecur(i+1, arr, k) + perfectSumRecur(i+1, arr, k-arr[i]);
    }

    public static void main(String[] args) {
        CountSubsetWithSumK solution = new CountSubsetWithSumK();

        test(solution, new int[]{2, 3, 5, 16, 8, 10}, 10, 3,
                "multiple valid subsets: [10], [2,8], [2,3,5]");
        test(solution, new int[]{1, 2, 3, 4, 5}, 5, 3,
                "different subset sizes: [5], [1,4], [2,3]");
        test(solution, new int[]{2, 2, 2, 2}, 4, 6,
                "duplicate values at different indices");
        test(solution, new int[]{0, 0, 1}, 1, 4,
                "zeros double every subset that already reaches the target");
        test(solution, new int[]{0, 0, 0}, 0, 8,
                "target zero with three independently selectable zeros");
        test(solution, new int[]{1, 2, 3}, 0, 1,
                "only the empty subset reaches zero when all values are positive");
        test(solution, new int[]{4, 6, 8}, 5, 0,
                "target cannot be formed");
        test(solution, new int[]{7}, 7, 1,
                "single element selected");
        test(solution, new int[]{7}, 3, 0,
                "single element cannot reach target");
        test(solution, new int[]{}, 0, 1,
                "empty input has one empty subset with sum zero");
    }

    private static void test(CountSubsetWithSumK solution, int[] arr, int k,
                             int expected, String reason) {
        int actual = solution.perfectSum(arr, k);
        String result = actual == expected ? "PASS" : "FAIL";
        System.out.printf("%s | arr=%s, k=%d | expected=%d, actual=%d | %s%n",
                result, Arrays.toString(arr), k, expected, actual, reason);
    }
}
