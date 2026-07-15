package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<String> getSubsequences(String s) {
        List<String> result = new ArrayList<>();
        getSubsequenceInner(0, s.length(), new StringBuilder(), s, result);
        return result;
    }

    private void getSubsequenceInner(int idx, int n, StringBuilder sb, String s, List<String> result) {
        if (idx == n) {
            result.add(sb.toString());
            return;
        }
        sb.append(s.charAt(idx));
        getSubsequenceInner(idx+1, n, sb, s, result);
        sb.deleteCharAt(sb.length()-1);
        getSubsequenceInner(idx+1, n, sb, s, result);
    }

    public static void main(String[] args) {
        String s = "abc";
        PowerSet solution = new PowerSet();
        CommonUtils.printListStr(solution.getSubsequences(s));
    }
}
