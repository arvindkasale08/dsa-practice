package com.arvind.revision.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int currentArea = Math.min(height[r], height[l]) * (r - l);
            maxArea = Math.max(currentArea, maxArea);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};
        int[] nums2 = new int[] {1, 1};
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(nums));
    }
}
