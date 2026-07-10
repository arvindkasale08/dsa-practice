package com.arvind.revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKMostDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int windowSize = Integer.MIN_VALUE;
        int l = 0;
        Map<Character, Integer> windowBank = new HashMap<>();
        for (int r=0; r<s.length(); r++) {
            windowBank.put(s.charAt(r), windowBank.getOrDefault(s.charAt(r), 0) + 1);
            // valid window
            if (windowBank.size() <= k) {
                windowSize = Math.max(windowSize, r-l+1);
            } else {
                // Invalid window make it valid
                // Remove from left
                while (windowBank.size() > k) {
                    Character c = s.charAt(l);
                    // remove from bank
                    if (windowBank.containsKey(c)) {
                        windowBank.put(c, windowBank.get(c) - 1);
                        if (windowBank.get(c) == 0) {
                            windowBank.remove(c);
                        }
                    }
                    l++;
                }
            }
        }

        return windowSize == Integer.MIN_VALUE ? 0 : windowSize;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        String s2 = "cbbebi";
        int k = 3;
        LongestSubstringWithKMostDistinctCharacters solution = new LongestSubstringWithKMostDistinctCharacters();
        System.out.println(solution.lengthOfLongestSubstringKDistinct(s2, k));
    }
}
