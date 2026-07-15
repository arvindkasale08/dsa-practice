package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumInner(0, candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationSumInner(int idx, int[] candidates, int currentSum, int target, List<Integer> list, List<List<Integer>> res) {
        // invalid
        if (currentSum > target) {
            return;
        }
        if (idx == candidates.length) {
            if (currentSum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        // stay at same after adding
        list.add(candidates[idx]);
        combinationSumInner(idx, candidates, currentSum + candidates[idx], target, list, res);
        list.remove(list.size() - 1);


        // just go to next
        combinationSumInner(idx + 1, candidates, currentSum, target, list, res);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        CommonUtils.printListListInt(solution.combinationSum(arr, target));
    }
}
