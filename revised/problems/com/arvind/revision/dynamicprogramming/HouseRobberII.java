package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length-1);
        return Math.max(robTab(nums1), robTab(nums2));
    }

    private int robTab(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i=1; i< nums.length; i++) {
            dp[i] = Math.max(nums[i] + (i > 1 ? dp[i-2] : 0), dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};
        HouseRobberII solution = new HouseRobberII();
        System.out.println(solution.rob(nums));
    }


}
