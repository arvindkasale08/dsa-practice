package com.arvind.revision.pod;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingMultipleOfK {

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> bank = new HashSet<>();
        for (int n : nums) {
            bank.add(n);
        }
        int num = k;
        while (true) {
            if (!bank.contains(num)) {
                return num;
            }
            num += k;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 7, 10, 15};
        int k = 5;
        SmallestMissingMultipleOfK solution = new SmallestMissingMultipleOfK();
        System.out.println(solution.missingMultiple(nums, k));
    }
}
