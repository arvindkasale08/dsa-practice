package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    private static final Map<Character, List<Character>> BANK = new HashMap<>() {
        {
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinationInner(0, digits, new StringBuilder(), result);
        return result;
    }

    private void letterCombinationInner(int idx, String digits, StringBuilder sb, List<String> result) {

        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (Character opt : BANK.get(digits.charAt(idx))) {
            sb.append(opt);
            letterCombinationInner(idx+1, digits, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        CommonUtils.printListStr(solution.letterCombinations(digits));
    }
}
