package neetcode;

import java.util.Arrays;

public class NumberLongestIncreasingSubsequence {

    // this is the actual solution for this problem you have to solve it the dp route.
    public int findNumberOfLISDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[n-1][0] = 1; // lis
        dp[n-1][1] = 1; // count of list at this dp[j]
        for (int i=n-2; i>=0; i--) {
            dp[i][0] = 1; // init with 1 lis for each
            dp[i][1] = 1; // init with 1 count for each
            for (int j=i+1; j<n; j++) {
                if (nums[j] > nums[i]) {
                    // valid lis
                    int newLength = 1 + dp[j][0];
                    if (dp[i][0] > newLength) {
                        continue;
                    } else if (dp[i][0] == newLength) {
                        dp[i][1] += dp[j][1];
                    } else {
                        dp[i][0] = newLength;
                        dp[i][1] = dp[j][1];
                    }
                }
            }
        }

        int max_val = Integer.MIN_VALUE;
        int count = 0;

        for (int[] d : dp) {
            if (d[0] < max_val) {
                continue;
            } else if (d[0] == max_val) {
                count = count + d[1];
            } else {
                max_val = d[0];
                count = d[1];
            }
        }

        return count;
    }

    // this is the recurrence solution for finding the length of a lis
    public int findNumberOfLISMemo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n+1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return findNumberOfLISMemo(0, -1, n, nums, memo);
    }

    private int findNumberOfLISMemo(int idx, int prevIdx, int n, int[] nums, int[][] memo) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx][prevIdx+1] != -1) {
            return memo[idx][prevIdx+1];
        }

        int dontPick = 0 + findNumberOfLISMemo(idx + 1, prevIdx, n, nums, memo);
        int pick = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            pick = 1 + findNumberOfLISMemo(idx+1, idx, n, nums, memo);
        }
        return memo[idx][prevIdx+1] = Math.max(pick, dontPick);
    }

    public static void main(String[] args) {
        NumberLongestIncreasingSubsequence solution = new NumberLongestIncreasingSubsequence();
        int[] nums = {1, 1, 1};
        int res = solution.findNumberOfLISDP(nums);
        System.out.println(res);
    }
}
