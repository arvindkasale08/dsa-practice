package arvind;

import java.util.Arrays;

public class UniquePathInGrid {

    public int countWays(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return countWays(m-1, n-1, dp);
    }

    private int countWays(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        int left = countWays(i, j - 1, dp);
        int up = countWays(i-1, j, dp);
        return left + up;
    }

    public static void main(String[] args) {
        UniquePathInGrid solution = new UniquePathInGrid();
        int m = 3, n = 7;
        int result = solution.countWays(3, 7);
        System.out.println(result);
    }
}
