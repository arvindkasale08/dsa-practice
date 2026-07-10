package com.arvind.revision.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> validWindow = new HashSet<>();
        int l = 0;
        int windowLength = Integer.MIN_VALUE;
        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            if (validWindow.contains(c)) {
                // shrink the window
                while (validWindow.contains(c)) {
                    validWindow.remove(s.charAt(l));
                    l++;
                }
                validWindow.add(c);
            } else {
                validWindow.add(c);
                windowLength = Math.max(windowLength, r-l+1);
            }
        }
        return windowLength == Integer.MIN_VALUE ? 0 : windowLength;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        LongestSubstringWithoutRepeatingChar solution = new LongestSubstringWithoutRepeatingChar();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
}
