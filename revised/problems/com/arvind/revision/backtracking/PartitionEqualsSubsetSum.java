package com.arvind.revision.backtracking;

import java.util.Arrays;

public class PartitionEqualsSubsetSum {

    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if (target % 2 != 0) return false;
        return checkSubsequenceSumInner(0, 0, nums, target / 2);
    }

    private boolean checkSubsequenceSumInner(int idx, int sum, int[] nums, int target) {
        if (idx == nums.length) {
            return sum == target;
        }

        return checkSubsequenceSumInner(idx+1, sum + nums[idx], nums, target) ||
                checkSubsequenceSumInner(idx+1, sum, nums, target);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,11,5,2};
        PartitionEqualsSubsetSum solution = new PartitionEqualsSubsetSum();
        System.out.println(solution.canPartition(nums));
    }
}
