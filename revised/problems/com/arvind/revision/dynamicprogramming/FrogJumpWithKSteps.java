package com.arvind.revision.dynamicprogramming;

import javax.naming.InterruptedNamingException;
import java.util.Arrays;

public class FrogJumpWithKSteps {

    public int solve(int[] height, int k) {
        int[][] dp = new int[height.length+1][height.length+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solveRecur(0, 0, k, dp, height);
    }

    public int solveRecur(int from, int to, int k, int[][] dp, int[] height) {
        if (to >= height.length) return 1_000_000;
        if (dp[from][to] != -1) return dp[from][to];
        int energy = Math.abs(height[from] - height[to]);
        if (to == height.length - 1) return energy;
        int minNextEnergy = Integer.MAX_VALUE;

        for (int i=1; i<=k; i++) {
            minNextEnergy = Math.min(minNextEnergy, solveRecur(to, to+i, k, dp, height));
        }
        dp[from][to] = energy + minNextEnergy;
        return dp[from][to];
    }

    public static void main(String[] args) {
        FrogJumpWithKSteps solution = new FrogJumpWithKSteps();

        String[] names = {
                "Single stair",
                "Two stairs",
                "Only one-step jumps",
                "Direct jump to end",
                "Given example",
                "Classic k=2 example"
        };

        int[][] testHeights = {
                {42},
                {10, 30},
                {10, 20, 10, 30},
                {10, 100, 10},
                {15, 4, 12, 11, 15},
                {30, 10, 60, 10, 60, 50}
        };

        int[] testK = {3, 1, 1, 2, 3, 2};
        int[] expected = {0, 20, 40, 0, 6, 40};

        for (int i = 0; i < testHeights.length; i++) {
            int actual = solution.solve(testHeights[i], testK[i]);
            System.out.println(names[i]
                    + ": expected=" + expected[i]
                    + ", actual=" + actual
                    + (actual == expected[i] ? " PASS" : " FAIL"));
        }

        // Intentionally unconditional: plain recursion repeatedly solves the
        // same states and should become impractically slow on this input.
        int[] tleHeights = new int[40];
        for (int i = 0; i < tleHeights.length; i++) {
            tleHeights[i] = (i * 37) % 100;
        }

        long start = System.currentTimeMillis();
        int tleAnswer = solution.solve(tleHeights, 3);
        long duration = System.currentTimeMillis() - start;

        System.out.println("Recursive TLE test: answer=" + tleAnswer
                + ", duration=" + duration + " ms");
    }
}
