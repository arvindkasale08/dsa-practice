package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        return minTotalTab(triangle);
        /*int m = triangle.size();
        Integer[][] dp = new Integer[m][m];
        //return minTotalMemo(0, 0, m, triangle, dp);*/
        //return minTotalRecur(0, 0, m, triangle);
    }

    private int minTotalTab(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<m; i++) {
            for (int j=0; j<=i; j++) {
                int top = dp[i-1][j];
                int topLeft = j == 0 ? Integer.MAX_VALUE : dp[i-1][j-1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(top, topLeft);
            }
        }

        return Arrays.stream(dp[m-1]).min().getAsInt();
    }

    private int minTotalMemo(int row, int col, int m, List<List<Integer>> triangle, Integer[][] dp) {
        if (row >= m) return 0;
        List<Integer> r = triangle.get(row);
        if (col >= r.size()) return 1_000_000;
        if (dp[row][col] != null) return dp[row][col];

        int down = minTotalMemo(row + 1, col, m, triangle, dp);
        int right = minTotalMemo(row + 1, col + 1, m, triangle, dp);
        dp[row][col] = r.get(col) + Math.min(down, right);
        return dp[row][col];
    }

    private int minTotalRecur(int row, int col, int m, List<List<Integer>> triangle) {
        if (row >= m) return 0;
        List<Integer> r = triangle.get(row);
        if (col >= r.size()) return 1_000_000;

        int down = minTotalRecur(row + 1, col, m, triangle);
        int right = minTotalRecur(row + 1, col + 1, m, triangle);
        return r.get(col) + Math.min(down, right);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        Triangle solution = new Triangle();
        System.out.println(solution.minimumTotal(triangle));
    }
}
