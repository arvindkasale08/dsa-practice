package com.arvind.revision.hashing;

import com.arvind.revision.common.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> bank = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (bank.containsKey(nums[i])) return new int[] {i, bank.get(nums[i])};
            bank.put(target - nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int[] nums2 = new int[] {3, 2, 4};
        int[] nums3 = new int[] {3, 3};
        TwoSum solution = new TwoSum();
        int[] res = solution.twoSum(nums, 9);
        int[] res2 = solution.twoSum(nums2, 6);
        int[] res3 = solution.twoSum(nums3, 6);
        CommonUtils.print(res);
        CommonUtils.print(res2);
        CommonUtils.print(res3);
    }
}
