package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2Inner(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum2Inner(int idx, int[] candidates, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0 ) return;
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=idx; i<candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i-1]) continue;
            // move to next while taking
            list.add(candidates[i]);
            combinationSum2Inner(i+1, candidates, target - candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII solution = new CombinationSumII();
        CommonUtils.printListListInt(solution.combinationSum2(candidates, target));
    }
}
