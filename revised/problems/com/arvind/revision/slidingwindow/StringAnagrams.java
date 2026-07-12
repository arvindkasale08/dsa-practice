package com.arvind.revision.slidingwindow;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        if (p.isEmpty()) return res;
        int[] bank = new int[26];
        // put the pattern in bank
        for (char c : p.toCharArray()) {
            bank[c-97] += 1;
        }
        int windowSize = p.length();

        // premove and calculate the window elements validness;
        int l = 0;
        int r = 0;
        while (r < windowSize) {
            char c = s.charAt(r);
            bank[c-97] -= 1;
            r++;
        }
        r--;
        if (isValid(bank)) {
            res.add(l);
        }

        while (r < s.length() - 1) {
            int lIdx = s.charAt(l) - 97;
            bank[lIdx] += 1;
            r++;
            l++;
            int rIdx = s.charAt(r) - 97;
            bank[rIdx] -= 1;
            if (isValid(bank)) {
                res.add(l);
            }
        }

        return res;
    }

    private boolean isValid(int[] ref) {
        for (int i : ref) {
            if (i > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ppqp";
        String p = "pq";
        String s1 = "cbaebabacdabc";
        String p1 = "abc";
        StringAnagrams solution = new StringAnagrams();
        CommonUtils.printList(solution.findAnagrams(s1, p1));
    }
}
