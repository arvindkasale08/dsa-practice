package com.arvind.revision.twopointers;

import com.arvind.revision.common.CommonUtils;

public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l+1, r+1};
            }
            if (sum > target) {
                r--;
            }
            if (sum < target) {
                l++;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2,7,11,15};
        int target = 9;
        TwoSumSorted solution = new TwoSumSorted();
        CommonUtils.print(solution.twoSum(numbers, target));
    }
}
