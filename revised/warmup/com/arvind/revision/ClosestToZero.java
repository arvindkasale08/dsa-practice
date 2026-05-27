package com.arvind.revision;

public class ClosestToZero {

    public int findClosestNumber(int[] nums) {
        int closest = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(closest)) {
                closest = nums[i];
            } else if (Math.abs(nums[i]) == Math.abs(closest)) {
                if (nums[i] > closest) {
                    closest = nums[i];
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, -1, 1};
        ClosestToZero closestToZero = new ClosestToZero();
        int result = closestToZero.findClosestNumber(nums);
        System.out.println(result);
    }
}
