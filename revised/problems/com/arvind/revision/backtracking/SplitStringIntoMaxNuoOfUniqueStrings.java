package com.arvind.revision.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitStringIntoMaxNuoOfUniqueStrings {

    public int maxUniqueSplit(String s) {
        List<Integer> maxLength = new ArrayList<>();
        maxUniqueSplitInner(0, s, maxLength, new HashSet<>());
        return maxLength.isEmpty() ? 0 : maxLength.get(0);
    }


    private void maxUniqueSplitInner(int idx, String s, List<Integer> maxLength, Set<String> set) {

        if (idx == s.length()) {
            int size = Math.max(set.size(), maxLength.isEmpty() ? 0 : maxLength.get(0));
            maxLength.add(0, size);
            return;
        }

        for (int i=idx; i< s.length(); i++) {
            String part = s.substring(idx, i+1);

            if (!set.contains(part)) {
                set.add(part);
                maxUniqueSplitInner(i+1, s, maxLength, set);
                set.remove(part);
            }
        }
    }

    public static void main(String[] args) {
        String s = "ababccc";
        SplitStringIntoMaxNuoOfUniqueStrings solution = new SplitStringIntoMaxNuoOfUniqueStrings();
        System.out.println(solution.maxUniqueSplit(s));
    }
}
