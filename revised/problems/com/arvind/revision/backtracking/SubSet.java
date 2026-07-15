package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsInner(0, nums.length, nums, new ArrayList<>(), res);
        return res;
    }

    private void subsetsInner(int idx, int n, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (idx == n ) {
            res.add(new ArrayList<>(list));
            return;
        }

        // dont pick the index;
        subsetsInner(idx+1, n, nums, list, res);
        // pick the index and then remove;
        list.add(nums[idx]);
        subsetsInner(idx+1, n, nums, list, res);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        SubSet solution = new SubSet();
        CommonUtils.printListListInt(solution.subsets(arr));
    }
}
