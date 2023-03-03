package neetcode;

import java.util.Arrays;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // populate the last row and last column as in from the matrix;
        for (int i=0; i<m; i++) {
            dp[i][n-1] = Character.getNumericValue(matrix[i][n-1]);
        }
        for (int j=0; j<n; j++) {
            dp[m-1][j] = Character.getNumericValue(matrix[m-1][j]);
        }

        for (int i=m-2; i>=0 ; i--) {
            for (int j=n-2; j>=0; j--) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j]));
                }
            }
        }

        int res = 0;
        for (int[] d : dp) {
            int e = Arrays.stream(d).max().getAsInt();
            res = Math.max(res, e * e);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalSquare solution = new MaximalSquare();
        char[][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = solution.maximalSquare(matrix);
        System.out.println(res);
    }
}
