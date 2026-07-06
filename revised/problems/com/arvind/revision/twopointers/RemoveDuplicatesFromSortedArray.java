package com.arvind.revision.twopointers;

import com.arvind.revision.common.CommonUtils;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;

        while (r < nums.length) {
            while (r < nums.length && nums[r] == nums[l]) {
                r++;
            }
            if (r >= nums.length)
                continue;
            nums[l + 1] = nums[r];
            l++;
            r++;
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        System.out.println(solution.removeDuplicates(nums));
        CommonUtils.print(nums);
    }
}
