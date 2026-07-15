package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();

        combinationSum3Inner(0, n, nums, k, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum3Inner(int idx, int target, int[] nums, int digitsLeft, List<Integer> list, List<List<Integer>> results) {
        if (target == 0 && digitsLeft == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        if (digitsLeft == 0) return;
        if (idx == nums.length) return;

        list.add(nums[idx]);
        combinationSum3Inner(idx + 1, target - nums[idx], nums, digitsLeft - 1, list, results);
        list.remove(list.size()-1);
        combinationSum3Inner(idx + 1, target, nums, digitsLeft, list, results);
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        CombinationSumIII solution = new CombinationSumIII();
        CommonUtils.printListListInt(solution.combinationSum3(k, n));
    }
}
