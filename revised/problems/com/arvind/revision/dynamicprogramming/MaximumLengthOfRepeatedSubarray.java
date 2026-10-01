package com.arvind.revision.dynamicprogramming;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length;
        int n = nums2.length;
        Integer[][] dp = new Integer[m+1][n+1];
        for (int i=0; i< m; i++) {
            for (int j=0; j < n; j++) {
                max = Math.max(max, findLengthMemo(i, j, nums1, nums2, dp));
            }
        }
        return max;
    }

    private int findLengthMemo(int i, int j, int[] nums1, int[] nums2, Integer[][] dp) {
        if (i >= nums1.length || j >= nums2.length) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + findLengthMemo(i+1, j+1, nums1, nums2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = 0;
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        MaximumLengthOfRepeatedSubarray solution = new MaximumLengthOfRepeatedSubarray();
        System.out.println(solution.findLength(nums1, nums2));
    }
}
