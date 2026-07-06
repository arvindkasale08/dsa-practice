package com.arvind.revision.twopointers;

public class MaximumProductOfTwoElementsInArray {

    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i=0; i< nums.length; i++) {
            if (nums[i] >= max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                max2 = nums[i];
            }
        }
        System.out.println(max1);
        System.out.println(max2);
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5,2};
        MaximumProductOfTwoElementsInArray solution = new MaximumProductOfTwoElementsInArray();
        System.out.println(solution.maxProduct(nums));
    }
}
