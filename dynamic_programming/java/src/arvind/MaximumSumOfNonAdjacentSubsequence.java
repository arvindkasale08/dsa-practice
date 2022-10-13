package arvind;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentSubsequence {


    public int maxSumTabulation(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i=1; i<n; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick += dp[i-2];
            }
            int dontpick = 0 + dp[i-1];

            dp[i] = Math.max(pick, dontpick);
        }
        return dp[dp.length - 1];
    }

    public int maxSum(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int result = maxSum(arr, n-1, dp);
        return result;
    }

    private int maxSum(int[] arr, int index, int[] dp) {
        if (index == 0 ) return arr[index];
        if (index < 0 ) return 0;
        if (dp[index] != -1) return dp[index];
        int pick = arr[index] + maxSum(arr, index - 2, dp);
        int notPick = 0 + maxSum(arr, index - 1, dp);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }

    public static void main(String[] args) {
        MaximumSumOfNonAdjacentSubsequence solution = new MaximumSumOfNonAdjacentSubsequence();
        int[] arr = {2, 1, 4, 9};
        int n = arr.length;
        int result = solution.maxSumTabulation(arr, n);
        System.out.println(result);
    }
}
