package com.arvind.revision.greedy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIdx = s.length - 1;
        int kidIdx = g.length - 1;

        while (cookieIdx >= 0 && kidIdx >= 0) {
            if (s[cookieIdx] >= g[kidIdx]) {
                contentChildren++;
                cookieIdx--;
                kidIdx--;
            } else {
                kidIdx--;
            }
        }

        return contentChildren;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int[] g1 = {1, 2};
        int[] s1 = {1, 2, 3};
        AssignCookies solution = new AssignCookies();
        System.out.println(solution.findContentChildren(g1, s1));
    }
}
