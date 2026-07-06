package com.arvind.revision.twopointers;

import com.arvind.revision.common.CommonUtils;

public class RearrangeBySign {

    public int[] rearrangeArray(int[] nums) {
        int[] temp = new int[nums.length];
        int positive = 0;
        int negative = 0;
        int i = 0;
        while (i < nums.length) {
            while (positive < nums.length && nums[positive] < 0) {
                positive++;
            }
            while (negative < nums.length && nums[negative] > 0) {
                negative++;
            }
            if (positive < nums.length) {
                temp[i] = nums[positive];
            }
            if (negative < nums.length) {
                temp[i + 1] = nums[negative];
            }
            positive++;
            negative++;
            i++;
            i++;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, -2, -5, 2, -4};
        RearrangeBySign solution = new RearrangeBySign();
        CommonUtils.print(solution.rearrangeArray(arr));
    }
}
