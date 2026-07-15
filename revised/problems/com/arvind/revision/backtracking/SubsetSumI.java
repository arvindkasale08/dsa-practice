package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumI {

    public List<Integer> subsetSums(int[] arr) {
        List<Integer> res = new ArrayList<>();
        subsetSumsInner(0, 0, arr, res);
        return res;
    }

    private void subsetSumsInner(int idx, int currSum, int[] arr, List<Integer> res) {
        if (idx == arr.length) {
            res.add(currSum);
            return;
        }
        subsetSumsInner(idx + 1, currSum, arr, res);
        subsetSumsInner(idx+1, currSum + arr[idx], arr, res);
    }

    public static void main(String[] args) {
        SubsetSumI solution = new SubsetSumI();

        int[] arr1 = new int[] {5, 2, 1};
        System.out.println("Input: [5, 2, 1]");
        System.out.println("Expected sorted sums: [0, 1, 2, 3, 5, 6, 7, 8]");
        CommonUtils.printList(solution.subsetSums(arr1));

        int[] arr2 = new int[] {3, 1, 2};
        System.out.println("Input: [3, 1, 2]");
        System.out.println("Expected sorted sums: [0, 1, 2, 3, 3, 4, 5, 6]");
        CommonUtils.printList(solution.subsetSums(arr2));

        int[] arr3 = new int[] {1, 1};
        System.out.println("Input: [1, 1]");
        System.out.println("Expected sorted sums: [0, 1, 1, 2]");
        CommonUtils.printList(solution.subsetSums(arr3));

        int[] arr4 = new int[] {};
        System.out.println("Input: []");
        System.out.println("Expected sorted sums: [0]");
        CommonUtils.printList(solution.subsetSums(arr4));
    }
}
