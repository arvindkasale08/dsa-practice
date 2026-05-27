package com.arvind.revision;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {



    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate dc = new ContainsDuplicate();
        int[] in = new int[]{1, 2, 3, 4, 4};
        boolean result = dc.containsDuplicate(in);
        System.out.println("Result: " + result);
    }
}
