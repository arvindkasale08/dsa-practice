package neetcode;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (memo[i][j] == -1) {
                    // not visited yet
                    dfs(i, j, memo, matrix, Integer.MIN_VALUE);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int[] me : memo) {
            max = Math.max(max, Arrays.stream(me).max().getAsInt());
        }
        return max;
    }

    private int dfs(int i, int j, int[][] memo, int[][] matrix, int parent) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] <= parent) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int left = dfs(i, j-1, memo, matrix, matrix[i][j]);
        int right = dfs(i, j+1, memo, matrix, matrix[i][j]);
        int up = dfs(i-1, j, memo, matrix, matrix[i][j]);
        int down = dfs(i+1, j, memo, matrix, matrix[i][j]);

        return memo[i][j] = 1 + Math.max(Math.max(left, right), Math.max(up, down));
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{9,9,4},{6,6,8},{2,1,1}};
        LongestIncreasingPathInMatrix solution = new LongestIncreasingPathInMatrix();
        int path = solution.longestIncreasingPath(matrix);
        System.out.println(path);
    }
}
