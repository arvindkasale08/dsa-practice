package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class PartitionToTwoArrayMinDiff {

    public int minimumDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Integer[][] dp = new Integer[nums.length][sum];
        for (Integer[] d : dp) {
            Arrays.fill(d, null);
        }
        return minimumDifferenceTab(0, 0, sum, nums, dp);
        /*return minimumDifferenceRecur(0, 0, sum, nums);*/
    }

    private int minimumDifferenceTab(int i, int sum, int total, int[] nums, Integer[][] dp) {
        if (i >= nums.length) return Math.abs(sum - (total - sum));
        if (dp[i][sum] != null) return dp[i][sum];
        int pick = minimumDifferenceTab(i+1, sum + nums[i], total, nums, dp);
        int dontPick = minimumDifferenceTab(i+1, sum, total, nums, dp);
        dp[i][sum] = Math.min(pick, dontPick);
        return dp[i][sum];
    }

    private int minimumDifferenceRecur(int i, int sum, int total, int[] nums) {
        if (i >= nums.length) return Math.abs(sum - (total - sum));
        int pick = minimumDifferenceRecur(i+1, sum + nums[i], total, nums);
        int dontPick = minimumDifferenceRecur(i+1, sum, total, nums);
        return Math.min(pick, dontPick);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 1, 5};
        PartitionToTwoArrayMinDiff solution = new PartitionToTwoArrayMinDiff();
        System.out.println("Answer is " + solution.minimumDifference(nums));
    }
}
