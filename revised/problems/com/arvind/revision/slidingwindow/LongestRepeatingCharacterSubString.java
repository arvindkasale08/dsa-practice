package com.arvind.revision.slidingwindow;

public class LongestRepeatingCharacterSubString {

    public int characterReplacement(String s, int k) {
        int windowSize = Integer.MIN_VALUE;
        int l = 0;
        int[] arr = new int[26];

        for (int r=0; r< s.length(); r++) {
            char c = s.charAt(r);
            arr[(((int)c)-65)] += 1; // increment window count for the character;
            if (isValid(arr, k, l, r)) {
                windowSize = Math.max(windowSize, r-l+1);
            } else {
                while (!isValid(arr, k, l, r)) {
                    arr[(((int)s.charAt(l))-65)] -= 1;
                    l++;
                }
            }
        }
        return windowSize == Integer.MIN_VALUE ? 0 : windowSize;
    }

    private boolean isValid(int[] arr, int k, int l, int r) {
        int maxFrequency = 0;
        for (int a : arr) {
            maxFrequency = Math.max(maxFrequency, a);
        }
        return maxFrequency + k >= (r-l+1);
    }

    public static void main(String[] args) {
        String str = "AABABBAAC";
        int k = 2;
        LongestRepeatingCharacterSubString solution = new LongestRepeatingCharacterSubString();
        System.out.println(solution.characterReplacement(str, k));
    }
}
