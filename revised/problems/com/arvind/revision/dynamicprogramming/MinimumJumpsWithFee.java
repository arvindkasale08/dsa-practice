package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class MinimumJumpsWithFee {

    public int findMinFee(int[] fee) {
        return findMinFeeTab(fee);
        /*int[] dp = new int[fee.length];
        Arrays.fill(dp, -1);
        return findMinFeeMemo(0, fee, dp);*/
        //return findMinFeeRecur(0, fee);
    }

    private int findMinFeeTab(int[] fee) {
        int[] dp = new int[fee.length + 1];
        Arrays.fill(dp, 1_000_000);
        dp[0] = 0;

        for (int i=0; i<fee.length; i++) {
            int j = 1;
            while (j <= 3) {
                int idx = Math.min(i + j, fee.length);
                dp[idx] = Math.min(dp[idx], dp[i] + fee[i]);
                j++;
            }
        }
        return dp[fee.length];
    }

    private int findMinFeeMemo(int i, int[] fee, int[] dp) {
        if (i >= fee.length) return 0;
        if(dp[i] != -1) return dp[i];

        int oneStep = findMinFeeMemo(i+1, fee, dp);
        int twoStep = findMinFeeMemo(i+2, fee, dp);
        int threeStep = findMinFeeMemo(i+3, fee, dp);
        dp[i] = fee[i] + Math.min(Math.min(oneStep, twoStep), threeStep);
        return dp[i];
    }

    private int findMinFeeRecur(int i, int[] fee) {
        if (i >= fee.length) return 0;

        int oneStep = findMinFeeRecur(i+1, fee);
        int twoStep = findMinFeeRecur(i+2, fee);
        int threeStep = findMinFeeRecur(i+3, fee);
        return fee[i] + Math.min(Math.min(oneStep, twoStep), threeStep);
    }

    public static void main(String[] args) {
        int[] fee = new int[] {2,3,4,5};
        MinimumJumpsWithFee solution = new MinimumJumpsWithFee();
        System.out.println(solution.findMinFee(fee));
    }
}
