package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return findTargetSumWaysMemo(0, target, nums, dp);
        //return findTargetSumWaysRecur(0, target, nums);
    }

    private int findTargetSumWaysMemo(int i, int target, int[] nums, Map<String, Integer> dp) {
        if (i == nums.length) return target == 0 ? 1 : 0;
        if (dp.containsKey(i+"_"+target)) return dp.get(i+"_"+target);
        int neg = findTargetSumWaysMemo(i+1, target - nums[i], nums, dp);
        int pos = findTargetSumWaysMemo(i+1, target + nums[i], nums, dp);
        dp.put(i+"_"+target, neg + pos);
        return neg + pos;
    }

    private int findTargetSumWaysRecur(int i, int target, int[] nums) {
        if (i == nums.length) return target == 0 ? 1 : 0;
        int neg = findTargetSumWaysRecur(i+1, target - nums[i], nums);
        int pos = findTargetSumWaysRecur(i+1, target + nums[i], nums);
        return neg + pos;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        TargetSum solution = new TargetSum();
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}
