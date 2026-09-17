package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        return canPartitionMemo(0, sum/2, nums, dp);
    }

    private boolean canPartitionMemo(int i, int k, int[] nums, Boolean[][] dp) {
        if (k == 0) return true;
        if (k < 0 || i >= nums.length) return false;
        if (dp[i][k] != null) return dp[i][k];
        dp[i][k] = canPartitionMemo(i+1, k, nums, dp) || canPartitionMemo(i+1, k-nums[i], nums, dp);
        return dp[i][k];
    }

    private boolean canPartitionRecur(int i, int k, int[] nums) {
        if (k == 0) return true;
        if (k < 0 || i >= nums.length) return false;
        return canPartitionRecur(i+1, k, nums) || canPartitionRecur(i+1, k-nums[i], nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,11,5,2};
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        System.out.println(solution.canPartition(nums));
    }
}
