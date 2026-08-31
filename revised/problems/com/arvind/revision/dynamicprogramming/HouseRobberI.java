package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberI {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robTab(nums);
        //return robMemo(0, nums, dp);
        //return robRecur(0, nums);
    }

    private int robRecur(int i, int[] nums) {

        if (i >= nums.length) return 0;
        //if (i == nums.length - 1) return nums[i];
        int pick = nums[i] + robRecur(i+2, nums);
        int dontPick = robRecur(i+1, nums);

        return Math.max(pick, dontPick);
    }

    private int robTab(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i=1; i< nums.length; i++) {
            dp[i] = Math.max(nums[i] + (i > 1 ? dp[i-2] : 0), dp[i-1]);
        }
        return dp[dp.length-1];
    }

    private int robMemo(int i, int[] nums, int[] dp) {
        if (i >= nums.length) return 0;
        //if (i == nums.length - 1) return nums[i];
        if (dp[i] != -1) return dp[i];
        int pick = nums[i] + robMemo(i+2, nums, dp);
        int dontPick = robMemo(i+1, nums, dp);
        dp[i] = Math.max(pick, dontPick);
        return dp[i];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobberI solution = new HouseRobberI();
        System.out.println(solution.rob(nums));
    }
}
