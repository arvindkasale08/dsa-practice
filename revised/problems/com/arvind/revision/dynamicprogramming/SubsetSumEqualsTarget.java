package com.arvind.revision.dynamicprogramming;

public class SubsetSumEqualsTarget {

    public boolean subsetSumToK(int[] arr, int k) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][k+1];
        return subsetSumToKMemo(0, k, arr, dp);
        // return subsetSumToKRecur(0, k, arr);
    }

    private boolean subsetSumToKMemo(int i, int k, int[] arr, Boolean[][] dp) {
        if (k == 0) return true;
        if (k < 0 || i >= arr.length) return false;
        if (dp[i][k] != null) return dp[i][k];
        dp[i][k] = subsetSumToKMemo(i+1, k, arr, dp) || subsetSumToKMemo(i+1, k-arr[i], arr, dp);
        return dp[i][k];
    }

    private boolean subsetSumToKRecur(int i, int k, int[] arr) {
        if (k == 0) return true;
        if (k < 0 || i >= arr.length) return false;
        return subsetSumToKRecur(i+1, k, arr) || subsetSumToKRecur(i+1, k-arr[i], arr);
    }

    public static void main(String[] args) {
        SubsetSumEqualsTarget solution = new SubsetSumEqualsTarget();

        int[][] arrays = {
                {4, 3, 5, 4},
                {2, 3, 1},
                {2, 3, 1},
                {1, 2, 7, 1, 5},
                {1, 2, 7, 1, 5},
                {4, 4, 4},
                {8},
                {8},
                {},
                {}
        };
        int[] targets = {6, 5, 7, 10, 17, 8, 8, 3, 0, 1};
        boolean[] expected = {false, true, false, true, false, true, true, false, true, false};

        for (int i = 0; i < arrays.length; i++) {
            boolean actual = solution.subsetSumToK(arrays[i], targets[i]);
            System.out.printf(
                    "Test %d: target=%d, expected=%s, actual=%s -> %s%n",
                    i + 1,
                    targets[i],
                    expected[i],
                    actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }

        if (true) {
            int[] recursionStress = new int[35];
            for (int i = 0; i < recursionStress.length; i++) {
                recursionStress[i] = 1;
            }

            int impossibleTarget = 36;
            System.out.println("Running opt-in recursion stress test; the recursive solution is expected to take a long time...");
            boolean actual = solution.subsetSumToK(recursionStress, impossibleTarget);
            System.out.printf(
                    "Stress test: target=%d, expected=false, actual=%s -> %s%n",
                    impossibleTarget,
                    actual,
                    !actual ? "PASS" : "FAIL"
            );
        }
    }
}
