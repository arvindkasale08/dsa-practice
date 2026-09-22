package com.arvind.revision.pod;

public class ReverseDegreeOfString {

    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            int val = 123 - (int) c;
            sum += val * (i+1);
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "zaza";
        String s1 = "abc";
        ReverseDegreeOfString solution = new ReverseDegreeOfString();
        System.out.println(solution.reverseDegree(s1));
    }
}
