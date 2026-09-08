package com.arvind.revision.pod;

public class CountCommasInRange {

    public int countCommas(int n) {
        return n < 1000 ? 0 : n - 1000 + 1;
    }

    public static void main(String[] args) {
        int n = 1002;
        CountCommasInRange solution = new CountCommasInRange();
        System.out.println(solution.countCommas(n));
    }
}
