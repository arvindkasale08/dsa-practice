package com.arvind.revision.twopointers;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        boolean flag = true;
        while (flag) {
            // move to elligible comparison
            i = ignoreBackspace(i, s, 0);
            j = ignoreBackspace(j, t, 0);
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--;
            j--;
        }
        if (i >= 0 || j >= 0) return false;
        return true;
    }

    private int ignoreBackspace(int i, String s, int offset) {
        if (i < 0) return i;
        char c = s.charAt(i);
        if (c != '#') {
            if (offset == 0) {
                return i;
            } else {
                return ignoreBackspace(i - 1, s, offset-1);
            }
        } else {
            if (i > 0) {
                return ignoreBackspace(i-1, s, offset+1);
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "abef###c";
        String s2 = "ad#c";
        String s3 = "ab##";
        String s4 = "c#d#";
        String s5 = "bxj##tw";
        String s6 = "bxo#j##tw";
        BackspaceStringCompare solution = new BackspaceStringCompare();
        System.out.println(solution.backspaceCompare(s5, s6));
    }
}
