package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupInner(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void subsetsWithDupInner(int idx, int[] nums, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));

        for (int i=idx; i<nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) {
                continue;
            }

            list.add(nums[i]);
            subsetsWithDupInner(i+1, nums, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2};
        SubsetII solution = new SubsetII();
        CommonUtils.printListListInt(solution.subsetsWithDup(nums));
    }
}
