package com.arvind.revision.pod;

public class RemovingMinMaxFromArray {

    public int minimumDeletions(int[] nums) {
        // find the index of min and max
        int minIdx = 0;
        int maxIdx = 0;
        if (nums.length == 1) return 1;

        for (int i=1; i<nums.length; i++) {
            int currVal = nums[i];
            minIdx = currVal < nums[minIdx] ? i : minIdx;
            maxIdx = currVal > nums[maxIdx] ? i : maxIdx;
        }

        int leftRemoval = Math.max(minIdx, maxIdx) + 1;
        int rightRemoval = nums.length - Math.min(minIdx, maxIdx);
        int middleRetain = (Math.min(minIdx, maxIdx) - 0 + 1) + (nums.length - Math.max(minIdx, maxIdx));

        return Math.min(Math.min(leftRemoval, rightRemoval), middleRetain);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,10,7,5,4,1,8,6};
        int[] nums2 = new int[] {0,-4,19,1,8,-2,-3,5};
        System.out.println(new RemovingMinMaxFromArray().minimumDeletions(nums));
    }
}
