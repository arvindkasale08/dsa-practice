package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class MinimumJumpsReachEnd {

    public int countMinJumps(int[] jumps) {
        int[] dp = new int[jumps.length];
        Arrays.fill(dp, -1);
        return countMinJumpsTab(jumps);
        //return countJumpsMemo(0, jumps, dp);
        //return countJumpsRecur(0, jumps);
    }

    public int countMinJumpsTab(int[] jumps) {
        int[] dp = new int[jumps.length];
        Arrays.fill(dp, 1_000_000);
        dp[0] = 0;
        for (int i=0; i<jumps.length - 1; i++) {
            int maxDist = jumps[i];
            for (int j=1; j<= maxDist; j++) {
                int idx = i + j;
                if (idx != i && idx < jumps.length) {
                    dp[idx] = Math.min(dp[idx], dp[i] + 1);
                }
            }
        }
        return dp[dp.length-1];
    }

    public int countJumpsMemo(int i, int[] jumps, int[] dp) {
        if (i >= jumps.length-1) return 0;
        if (jumps[i] == 0) return 1_000_000;
        if (dp[i] != -1) return dp[i];
        int minJumps = 1_000_000;
        int itr = 1;
        while(itr <= jumps[i]) {
            minJumps = Math.min(minJumps, 1 + countJumpsMemo(i+itr, jumps, dp));
            itr++;
        }
        dp[i] = minJumps;
        return dp[i];
    }

    private int countJumpsRecur(int i, int[] jumps) {
        if (i >= jumps.length-1) return 0;
        if (jumps[i] == 0) return 1_000_000;
        int minJumps = 1_000_000;
        int itr = 1;
        while(itr <= jumps[i]) {
            minJumps = Math.min(minJumps, 1 + countJumpsRecur(i+itr, jumps));
            itr++;
        }
        return minJumps;
    }

    public static void main(String[] args) {
        int[] jumps = {1,1,3,6,9,3,0,1,3};
        MinimumJumpsReachEnd solution = new MinimumJumpsReachEnd();
        System.out.println(solution.countMinJumps(jumps));
    }
}
