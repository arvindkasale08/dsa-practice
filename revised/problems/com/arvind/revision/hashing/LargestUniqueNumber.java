package com.arvind.revision.hashing;

import java.util.HashMap;

public class LargestUniqueNumber {

    public int largestUniqueNumber(int[] arr) {
        int res = Integer.MIN_VALUE;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int a: arr) {
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        }

        for (int a : arr) {
            if (countMap.get(a) == 1 && a > res) {
                res = a;
            }
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,3,9,4,9,8,3,1};
        int[] nums2 = new int[] {9, 9, 8, 8};
        LargestUniqueNumber solution = new LargestUniqueNumber();
        System.out.println(solution.largestUniqueNumber(nums));
        System.out.println(solution.largestUniqueNumber(nums2));
    }
}
