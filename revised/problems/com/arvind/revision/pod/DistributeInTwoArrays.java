package com.arvind.revision.pod;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class DistributeInTwoArrays {

    public int[] resultArray(int[] nums) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int[] res = new int[nums.length];

        left.add(nums[0]);
        right.add(nums[1]);

        for (int i=2; i<nums.length; i++) {
            if (left.get(left.size()-1) > right.get(right.size()-1)) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }
        int i = 0;
        while (i < left.size()) {
            res[i] = left.get(i);
            i++;
        }
        int j = 0;
        while (j < right.size()) {
            res[i] = right.get(j);
            i++;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7, 4, 9, 2, 8, 6};
        DistributeInTwoArrays solution = new DistributeInTwoArrays();
        CommonUtils.print(solution.resultArray(arr));
    }
}
