package com.arvind.revision;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;

        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s1= "abc";
        String s2= "ahbgdc";
        IsSubsequence solution = new IsSubsequence();
        System.out.println(solution.isSubsequence(s1, s2));
    }
}
