package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class FibonacciNumber {

    public int fib(int n) {
        //int[] dp = new int[n+1];
        //Arrays.fill(dp, -1);
        //return fibRecur(n);
        //return fibMemo(n, dp);
        return fibTabBetter(n);
    }

    public int fibTabBetter(int n) {
        if (n <= 1) return n;
        int l = 0;
        int r = 1;
        int ans = 0;
        for (int i=2; i<n+1; i++) {
            ans = l + r;
            l = r;
            r = ans;
        }
        return ans;
    }

    public int fibTab(int n) {
        if(n <=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length-1];
    }

    public int fibMemo(int n, int[] dp) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = fibMemo(n-1, dp) + fibMemo(n-2, dp);
        return dp[n];
    }

    public int fibRecur(int n) {
        if (n == 0 || n == 1) return n;
        return fibRecur(n-1) + fibRecur(n-2);
    }

    public static void main(String[] args) {
        int n = 4;
        FibonacciNumber solution = new FibonacciNumber();
        System.out.println(solution.fib(n));
    }
}
