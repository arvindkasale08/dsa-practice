package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RatMaze {

    public List<String> findPath(int[][] arr) {
        List<String> result = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;
        int[][] visited = new int[m][n];
        dfs(0, 0, m, n, "", visited, arr, result);
        return result;
    }

    private void dfs(int i, int j, int m, int n, String path, int[][] visited, int[][] arr, List<String> result) {
        if (i == m-1 && j == n-1) {
            result.add(path);
            return;
        }

        if (isSafe(i, j, m, n, visited, arr)) {
            visited[i][j] = 1;
            dfs(i-1, j, m, n, path + "U", visited, arr, result);
            dfs(i, j+1, m, n, path + "R", visited, arr, result);
            dfs(i+1, j, m, n, path + "D", visited, arr, result);
            dfs(i, j-1, m, n, path + "L", visited, arr, result);
            visited[i][j] = 0;
        }

    }

    private boolean isSafe(int i, int j, int m, int n, int[][] visited, int[][] arr) {
        if (i >=0 && i < m && j >= 0 && j < n && visited[i][j] == 0 && arr[i][j] != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        runTest("classic 4x4 with two paths", new int[][] {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        }, Arrays.asList("DDRDRR", "DRDDRR"));

        runTest("single open cell", new int[][] {
                {1}
        }, Collections.singletonList(""));

        runTest("snake path that requires real left moves", new int[][] {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        }, Collections.singletonList("RRRRDDLLLLDDRRRR"));

        runTest("two-by-two open grid", new int[][] {
                {1, 1},
                {1, 1}
        }, Arrays.asList("RD", "DR"));
    }

    private static void runTest(String name, int[][] grid, List<String> expected) {
        RatMaze solution = new RatMaze();
        List<String> actual = solution.findPath(grid);
        Collections.sort(actual);
        List<String> sortedExpected = new ArrayList<>(expected);
        Collections.sort(sortedExpected);

        System.out.println(name);
        System.out.println("Expected: " + sortedExpected);
        System.out.println("Actual:   " + actual);
        System.out.println(actual.equals(sortedExpected) ? "✅ PASS" : "❌ FAIL");
        System.out.println("#################");
    }
}
