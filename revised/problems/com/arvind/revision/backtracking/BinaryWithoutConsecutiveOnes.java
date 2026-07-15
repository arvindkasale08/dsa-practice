package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class BinaryWithoutConsecutiveOnes {

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        validStringsInner("", n, res);
        return res;
    }

    private void validStringsInner(String s, int n, List<String> res) {
        if (s.length() == n) {
            res.add(s);
            return;
        };
        // 0 is added unconditionally
        validStringsInner(s + "0", n, res);
        // 1 is added only if last isn't 1
        if (s.isEmpty() || s.charAt(s.length()-1) != '1') {
            validStringsInner(s + "1", n, res);
        }
    }

    public static void main(String[] args) {
        BinaryWithoutConsecutiveOnes solution = new BinaryWithoutConsecutiveOnes();
        CommonUtils.printListStr(solution.validStrings(3));
    }
}
