package arvind;

import java.util.Arrays;

public class TriangleProblem {

    public int findMinPathSum(int[][] triangle) {
        int m = triangle.length;
        int n= m;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findMinPathSum(triangle, 0, 0, dp);
    }

    private int findMinPathSum(int[][] triangle, int i, int j, int[][] dp) {
        // when we reach the last row
        if (i == triangle.length - 1) {
            return triangle[i][j];
        }
        // bounds
        if (i >= triangle.length || j >= triangle[i].length) {
            return 1000000;
        }
        // introduce dp
        if (dp[i][j] != -1) return dp[i][j];

        int down = findMinPathSum(triangle, i+1, j, dp) + triangle[i][j];
        int diagright = findMinPathSum(triangle, i+1, j+1, dp) + triangle[i][j];

        return dp[i][j] = Math.min(down, diagright);
    }

    public static void main(String[] args) {
        TriangleProblem solution = new TriangleProblem();
        int[][] triangle = new int[][] {
                {10},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        int minPathSum = solution.findMinPathSum(triangle);
        System.out.println(minPathSum);
    }
}
