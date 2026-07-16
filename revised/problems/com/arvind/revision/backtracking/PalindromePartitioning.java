package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionInner(0, s, new ArrayList<>(), result);
        return result;
    }

    private void partitionInner(int idx, String s, List<String> list, List<List<String>> result) {
        if (idx == s.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int k=idx; k< s.length(); k++) {
            String path = s.substring(idx, k+1);
            if (isPalindrome(path)) {
                list.add(path);
                partitionInner(k+1, s, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabbaa";
        PalindromePartitioning solution = new PalindromePartitioning();
        CommonUtils.print(solution.partition(s));
    }
}
