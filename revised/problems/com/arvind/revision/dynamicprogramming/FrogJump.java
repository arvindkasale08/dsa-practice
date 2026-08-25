package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class FrogJump {

    private int solve(int[] height) {
        /*if (height.length <= 1) return 0;
        int[][] dp = new int[height.length][height.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        //return Math.min(solveRecur(0, 1, height), solveRecur(0, 2, height));
        return Math.min(solveMemo(0, 1, dp, height), solveMemo(0, 2, dp, height));*/
        return solveTab(height);
    }

    private int solveTab(int[] height) {
        if (height.length <= 1) return 0;
        int first = 0;
        int second = Math.abs(height[0]- height[1]);
        int third = second;

        for (int i=2; i<height.length; i++) {
            third = Math.min(first + Math.abs(height[i] - height[i-2]), second + Math.abs(height[i] - height[i-1]));
            first = second;
            second = third;
        }
        return third;
    }

    private int solveMemo(int from, int to, int[][] dp, int[] heights) {
        if (to >= heights.length) return 1_000_000;
        if (dp[to][from] != -1) return dp[to][from];
        int energy = Math.abs(heights[to] - heights[from]);
        if (to == heights.length - 1) return energy;
        dp[to][from] = Math.min(energy + solveMemo(to, to+1, dp, heights), energy + solveMemo(to, to+2, dp, heights));
        return dp[to][from];
    }

    private int solveRecur(int from, int to, int[] heights) {
        if (to >= heights.length) return 1_000_000;

        int energy = Math.abs(heights[to] - heights[from]);
        if (to == heights.length - 1) return energy;
        return Math.min(energy + solveRecur(to, to+1, heights), energy + solveRecur(to, to+2, heights));
    }

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();

        solution.runTest("Single stair", new int[]{7}, 0);
        solution.runTest("Two stairs", new int[]{10, 20}, 10);
        solution.runTest("Given example", new int[]{7, 5, 1, 2, 6}, 9);
        solution.runTest("Jump over middle stair", new int[]{10, 20, 30, 10}, 20);
        solution.runTest("Equal heights", new int[]{5, 5, 5, 5}, 0);

        // Run with --tle only when you intentionally want to observe the
        // exponential recursive solution becoming impractically slow.
        //if (args.length > 0 && "--tle".equals(args[0])) {
        if (true) {
            int[] tleHeights = new int[50];
            for (int i = 0; i < tleHeights.length; i++) {
                tleHeights[i] = (i * 37) % 100;
            }

            long start = System.currentTimeMillis();
            int answer = solution.solve(tleHeights);
            long duration = System.currentTimeMillis() - start;

            System.out.println("TLE stress test: answer=" + answer
                    + ", duration=" + duration + " ms");
        }
    }

    private void runTest(String name, int[] heights, int expected) {
        int actual = solve(heights);
        System.out.println(name + ": expected=" + expected
                + ", actual=" + actual
                + (actual == expected ? " PASS" : " FAIL"));
    }
}
