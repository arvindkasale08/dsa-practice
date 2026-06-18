package com.arvind.revision.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> bank = new HashMap<>();
        for (char c : s.toCharArray()) {
            bank.put(c, bank.getOrDefault(c, 0) + 1);
        }
        int count = 0;

        for (Integer val : bank.values()) {
            count += 2 * (val > 1 ? val / 2 : 0);
        }

        return count % 2 == 0 && s.length() > count ? count + 1 : count;
    }

    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "a";
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindrome(s1));
        System.out.println(solution.longestPalindrome(s2));
    }
}
