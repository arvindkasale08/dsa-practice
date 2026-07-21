package com.arvind.revision.greedy;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return validPalindromeInner(s, i + 1, j) || validPalindromeInner(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean validPalindromeInner(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbbcc";
        ValidPalindromeII solution = new ValidPalindromeII();
        System.out.println(solution.validPalindrome(s));
    }
}
