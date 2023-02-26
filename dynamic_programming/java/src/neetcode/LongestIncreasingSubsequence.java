package neetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLisDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for (int i=n-1; i >= 0; i--) {
            for (int prev=i - 1; prev >= -1; prev--) {
                int pick = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    pick = 1 + dp[i+1][i+1];
                }
                int notpick = 0 + dp[i+1][prev+1];
                dp[i][prev+1] = Math.max(pick, notpick);
            }
        }
        return dp[0][0];
    }

    public int lengthOfLISMemo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n+1];
        for (int[] arr : memo) {
            Arrays.fill(arr, - 1);
        }
        return lengthOfLISMemo(0, -1, n, memo, nums);
    }

    private int lengthOfLISMemo(int idx, int prevIdx, int n, int[][] memo, int[] nums) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx][prevIdx+1] != -1) {
            return memo[idx][prevIdx+1];
        }
        // when can I pick
        int pick = Integer.MIN_VALUE;
        if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
            pick = 1 + lengthOfLISMemo(idx+1, idx, n, memo, nums);
        }
        int dontPick = 0 + lengthOfLISMemo(idx+1, prevIdx, n, memo, nums);
        return memo[idx][prevIdx+1] = Math.max(pick, dontPick);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 1, 2};
        int res = solution.lengthOfLISMemo(nums);
        int res2 = solution.lengthOfLisDP(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}
