package com.arvind.revision.twopointers;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxSoFar = nums[0];
        for (int i=1; i< nums.length; i++) {
            if (nums[i] < maxSoFar) {
                right = i;
            }
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }
        int minSoFar = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] > minSoFar) {
                left = i;
            }
            minSoFar = Math.min(minSoFar, nums[i]);
        }

        System.out.println(right);
        System.out.println(left);
        return left == 0 && right == 0 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,6,4,8,10,9,15};
        ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();
        System.out.println(solution.findUnsortedSubarray(arr));
    }
}
