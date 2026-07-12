package com.arvind.revision.slidingwindow;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        // pattern cant be larger than the string.
        if (s1.length() > s2.length()) return false;
        int[] refBank = new int[26];
        for (char c : s1.toCharArray()) {
            refBank[c-97] += 1;
        }
        int l = 0;
        int r = 0;
        // premove and build the window / fixed size
        while (r < s1.length()) {
            char c = s2.charAt(r);
            int idx = c-97;
            refBank[idx] -=1;
            r++;
        }
        r--;
        if (isValid(refBank)) return true;
        while (r < s2.length() - 1) {
            int lIdx = s2.charAt(l) - 97;
            refBank[lIdx] += 1;
            r++;
            l++;
            int rIdx = s2.charAt(r) - 97;
            refBank[rIdx] -= 1;
            if (isValid(refBank)) return true;
        }

        return false;
    }

    private boolean isValid(int[] ref) {
        for (int i : ref) {
            if (i < 0) continue;
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "dc";
        String s2 = "ocdicf";
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
