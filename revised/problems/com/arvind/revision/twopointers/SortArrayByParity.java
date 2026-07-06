package com.arvind.revision.twopointers;

import com.arvind.revision.common.CommonUtils;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] % 2 != 0 && nums[r] % 2 == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            } else {
                if (nums[l] % 2 == 0) {
                    l++;
                }
                if (nums[r] % 2 != 0) {
                    r--;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,1,2,4};
        SortArrayByParity solution = new SortArrayByParity();
        CommonUtils.print(solution.sortArrayByParity(nums));
    }
}
