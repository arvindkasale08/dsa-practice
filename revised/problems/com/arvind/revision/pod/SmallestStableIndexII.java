package com.arvind.revision.pod;

public class SmallestStableIndexII {

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minValue = new int[n];
        minValue[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minValue[i] = Math.min(minValue[i + 1], nums[i]);
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            if (maxValue - minValue[i] <= k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,0,1,4};
        int k = 3;
        SmallestStableIndexII solution = new SmallestStableIndexII();
        System.out.println(solution.firstStableIndex(nums, k));
    }
}
