package com.arvind.revision.slidingwindow;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                size = Math.min(size, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        System.out.println(solution.minSubArrayLen(7, arr));
    }
}
